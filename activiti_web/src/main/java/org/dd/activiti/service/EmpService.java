package org.dd.activiti.service;

import org.dd.activiti.bean.Emp;
import org.dd.activiti.dao.impl.EmpDao;
import org.dd.activiti.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	@Autowired
	private EmpDao empDao;
	
	public void getEmpByEmp(Emp emp, Page<Emp> page){
		page.setTotal(empDao.countByEmp(emp));
		page.setRows(empDao.findByEmp(emp, page.getFirst(), page.getFirst() + page.getPageSize()));
	}
}
