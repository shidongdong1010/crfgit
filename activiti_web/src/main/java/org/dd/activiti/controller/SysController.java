package org.dd.activiti.controller;

import java.util.List;

import javax.annotation.Resource;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.dd.activiti.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 系统管理控制器
 *
 * @author SDD
 */
@Controller
@RequestMapping(value = "/sys")
public class SysController{
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name="identityService")
    private IdentityService identityService;
    
    @RequestMapping(value = "/index")
    public String index(HttpSession session) {
        return "/index";
    }

    
    /**
     * 系统登陆
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(
    		@RequestParam("userName") String userName, 
    		@RequestParam("password") String password,
    		HttpSession session, HttpServletRequest request) {
    	if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
    		request.setAttribute("message", "用户名或密码不能为空");
    		return "/login";
    	}
        boolean checkPassword = identityService.checkPassword(userName, password);
        
        if (checkPassword) {

            // read user from database
            User user = identityService.createUserQuery().userId(userName).singleResult();
            UserUtil.saveUserToSession(session, user);

            List<Group> groupList = identityService.createGroupQuery().groupMember(userName).list();
            session.setAttribute("groups", groupList);

            String[] groupNames = new String[groupList.size()];
            for (int i = 0; i < groupNames.length; i++) {
                System.out.println(groupList.get(i).getName());
                groupNames[i] = groupList.get(i).getName();
            }

            session.setAttribute("groupNames", ArrayUtils.toString(groupNames));

            return "redirect:/sys/index.do";
        } else {
        	request.setAttribute("message", "用户名或密码错误");
            return "/login";
        }
    }
    
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        UserUtil.removeUserFromSession(session);
        return "/login";
    }
}
