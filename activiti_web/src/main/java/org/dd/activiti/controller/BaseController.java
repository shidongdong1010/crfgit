package org.dd.activiti.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class BaseController {

	public void writer(HttpServletResponse response, String str){
        try {
			response.getWriter().print(str);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
