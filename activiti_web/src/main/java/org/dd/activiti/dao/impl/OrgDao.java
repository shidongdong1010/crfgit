package org.dd.activiti.dao.impl;

import java.util.List;

import org.dd.activiti.bean.Org;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrgDao extends BaseDao {

	public List<Org> findAll(){
		StringBuilder sql = new StringBuilder();
		sql.append("	select o.pri_number     priNumber,	");
		sql.append("	       o.no,	");
		sql.append("	       o.name,	");
		sql.append("	       o.status,	");
		sql.append("	       o.org_desc       orgDesc,	");
		sql.append("	       o.create_name    createName,	");
		sql.append("	       o.create_date    createDate,	");
		sql.append("	       o.is_hq_pi_enter isHQPiEnter	");
		sql.append("	  from crf_salary_p2p_org o	");

		return getJdbcTemplate().query(sql.toString(), BeanPropertyRowMapper.newInstance(Org.class));
	}
}
