package org.dd.activiti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dd.activiti.bean.Emp;
import org.dd.activiti.service.EmpService;
import org.dd.activiti.util.Page;
import org.dd.activiti.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 用户管理控制器
 *
 * @author SDD
 */
@Controller
@RequestMapping(value = "/emp")
public class EmpController extends BaseController{

	@Autowired
	private EmpService empService;
	
    /**
     * 员工列表
     *
     * @return
     */
    @RequestMapping(value = "/emp-list-init")
    public String empListInit(HttpServletRequest request, HttpServletResponse response) {
        return "emp-list";
    }
    
    /**
     * 员工列表
     *
     * @return
     */
    @RequestMapping(value = "/emp-list")
    public String empList(Emp emp, HttpServletRequest request, HttpServletResponse response) {
    	Page<Emp> page = new Page<Emp>();
    	PageUtil.init(page, request);
    	empService.getEmpByEmp(emp, page);
    	this.writer(response, page.toJsonString());
    	return null;
    }
}
