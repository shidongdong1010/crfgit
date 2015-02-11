package org.dd.activiti;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class Day3 {
	// 加载流程核心
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	// 得到任务服务
	TaskService taskService = processEngine.getTaskService();
	// 得到资源服务
	RepositoryService repositoryService = processEngine.getRepositoryService();
	
	@Test
	public void queryProcessDefinition() throws Exception{
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		query.processDefinitionKey("myProcess");
		List<ProcessDefinition> list = query.list();
		for(ProcessDefinition pd : list){
			System.out.println("id: "+pd.getId()+", name: "+pd.getName()+", key: "+pd.getKey()+", version:"+pd.getVersion());
			ProcessDefinitionImpl pdImpl = (ProcessDefinitionImpl) repositoryService.getProcessDefinition(pd.getId());
			System.out.println(pdImpl.getActivities());
		}
	}
	
	@Test
	public void queryImage() throws Exception {
		String deploymentId = "1";
		List<String> names = repositoryService.getDeploymentResourceNames(deploymentId);
		
		String resourceName = null;
		for(String name : names){
			if(name.indexOf(".png") >= 0){
				resourceName = name;
			}
		}
		if(resourceName == null) return;
		InputStream in = repositoryService.getResourceAsStream(deploymentId, resourceName);
		FileUtils.copyInputStreamToFile(in, new File("D:/"+resourceName));
	}
}
