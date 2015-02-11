package org.dd.activiti.service;

import java.util.List;

import org.dd.activiti.bean.Org;
import org.dd.activiti.dao.impl.OrgDao;
import org.dd.activiti.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {

	@Autowired
	private OrgDao orgDao;
	
	public void getAll(Page<Org> page){
		List<Org>  list = orgDao.findAll();
		page.setTotal(list.size());
		page.setRows(list);
	}
}
