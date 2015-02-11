package org.dd.activiti.controller.workflow;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.apache.commons.io.FilenameUtils;
import org.dd.activiti.util.DateUtils;
import org.dd.activiti.util.FileUtil;
import org.dd.activiti.util.Page;
import org.dd.activiti.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

/**
 * 流程管理控制器
 *
 * @author HenryYan
 */
@Controller
@RequestMapping(value = "/workflow")
public class ActivitiController {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ManagementService managementService;

    @Autowired
    private ProcessEngineFactoryBean processEngine;
    
    /**
     * 流程定义列表
     *
     * @return
     */
    @RequestMapping(value = "/process-list-init")
    public ModelAndView processListInit(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("workflow/process-list");
        return mav;
    }
    
    /**
     * 流程定义列表
     *
     * @return
     */
    @RequestMapping(value = "/process-list")
    public ModelAndView processList(HttpServletRequest request, HttpServletResponse response) {
	    /*
	     * 保存两个对象，一个是ProcessDefinition（流程定义），一个是Deployment（流程部署）
	     */
        Map<Object, Object> objects = new HashMap<Object, Object>();
        List<Map<Object, Object>> rows = new ArrayList<Map<Object, Object>>();

        Page<Object[]> page = new Page<Object[]>(PageUtil.PAGE_SIZE);
        int[] pageParams = PageUtil.init(page, request);

        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery().orderByDeploymentId().desc();
        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.listPage(pageParams[0], pageParams[1]);
        for (ProcessDefinition processDefinition : processDefinitionList) {
            String deploymentId = processDefinition.getDeploymentId();
            Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
            //objects.add(new Object[]{processDefinition, deployment});
            Map<Object, Object> row = new HashMap<Object, Object>();
            row.put("id", processDefinition.getId());
            row.put("deploymentId", processDefinition.getDeploymentId());
            row.put("name", processDefinition.getName());
            row.put("key", processDefinition.getKey());
            row.put("version", processDefinition.getVersion());
            row.put("resourceName", processDefinition.getResourceName());
            row.put("diagramResourceName", processDefinition.getDiagramResourceName());
            row.put("suspended", processDefinition.isSuspended());
            row.put("deploymentTime", DateUtils.format(deployment.getDeploymentTime(), DateUtils.YDMHMS_DASH));
            rows.add(row);
        }
        objects.put("rows", rows);
        objects.put("total", processDefinitionQuery.count());

        //return mav;
        String jsionstr = JSON.toJSONString(objects);
        try {
			response.getWriter().print(jsionstr);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    /**
     * 流程定义图片
     *
     * @return
     */
    @RequestMapping(value = "/process-image")
    public void processImage(HttpServletRequest request, HttpServletResponse response, 
    		@RequestParam("deploymentId") String deploymentId, 
    		@RequestParam("resourceName") String resourceName) {
		try {
			InputStream in = repositoryService.getResourceAsStream(deploymentId, resourceName);
			byte data[] = FileUtil.readInputStream(in); 
			response.setContentType("image/jpg"); // 设置返回的文件类型
			OutputStream os = response.getOutputStream();
			os.write(data);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 流程定义XML
     *
     * @return
     */
    @RequestMapping(value = "/process-xml")
    public void processXml(HttpServletRequest request, HttpServletResponse response, 
    		@RequestParam("deploymentId") String deploymentId, 
    		@RequestParam("resourceName") String resourceName) {
		try {
			InputStream in = repositoryService.getResourceAsStream(deploymentId, resourceName);
			byte data[] = FileUtil.readInputStream(in); 
			//response.setContentType("text/html"); // 设置返回的文件类型
			OutputStream os = response.getOutputStream();
			os.write(data);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value = "/deploy")
    public String deploy(@RequestParam(value = "file", required = false) MultipartFile file) {

        String fileName = file.getOriginalFilename();

        try {
            InputStream fileInputStream = file.getInputStream();

            String extension = FilenameUtils.getExtension(fileName);
            if (extension.equals("zip") || extension.equals("bar")) {
                ZipInputStream zip = new ZipInputStream(fileInputStream);
                repositoryService.createDeployment().addZipInputStream(zip).deploy();
            } else {
                repositoryService.createDeployment().addInputStream(fileName, fileInputStream).deploy();
            }
        } catch (Exception e) {
            logger.error("error on deploy process, because of file input stream", e);
        }

        return "redirect:/workflow/process-list-init.do";
    }
    
    /**
     * 删除部署的流程，级联删除流程实例
     *
     * @param deploymentId 流程部署ID
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("deploymentId") String deploymentId) {
        repositoryService.deleteDeployment(deploymentId, true);
        return "redirect:/workflow/process-list-init.do";
    }
}
