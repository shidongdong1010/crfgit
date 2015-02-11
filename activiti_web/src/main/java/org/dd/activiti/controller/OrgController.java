package org.dd.activiti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dd.activiti.bean.Emp;
import org.dd.activiti.bean.Org;
import org.dd.activiti.service.OrgService;
import org.dd.activiti.util.Page;
import org.dd.activiti.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 城市管理控制器
 *
 * @author SDD
 */
@Controller
@RequestMapping(value = "/org")
public class OrgController extends BaseController{

	@Autowired
	private OrgService orgService;
	
    /**
     * 城市列表
     *
     * @return
     */
    @RequestMapping(value = "/org-list-init")
    public String orgListInit(HttpServletRequest request, HttpServletResponse response) {
        return "org-list";
    }
    
    /**
     * 城市列表
     *
     * @return
     */
    @RequestMapping(value = "/org-list")
    public String orgList(Emp emp, HttpServletRequest request, HttpServletResponse response) {
    	Page<Org> page = new Page<Org>();
    	PageUtil.init(page, request);
    	orgService.getAll(page);
    	this.writer(response, page.toJsonString());
    	return null;
    }
}
