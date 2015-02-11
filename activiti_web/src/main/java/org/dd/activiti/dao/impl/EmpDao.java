package org.dd.activiti.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dd.activiti.bean.Emp;
import org.dd.activiti.util.Page;
import org.dd.activiti.util.PageUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.mysql.fabric.xmlrpc.base.Array;

@Repository
public class EmpDao extends BaseDao {

	public Emp getEmp(String empNo){
		StringBuilder sql = new StringBuilder();
		sql.append("	select e.pri_number          priNumber,	");
		sql.append("	       e.emp_no              empNo,	");
		sql.append("	       e.emp_name            empName,	");
		sql.append("	       e.emp_spell           empSpell,	");
		sql.append("	       e.sex                 sex,	");
		sql.append("	       e.id_type             idType,	");
		sql.append("	       e.id_card             idCard,	");
		sql.append("	       e.marriage            marriage,	");
		sql.append("	       e.family_phone        familyPhone,	");
		sql.append("	       e.mobile_phone        mobilePhone,	");
		sql.append("	       e.eamil               eamil,	");
		sql.append("	       e.native_place        nativePlace,	");
		sql.append("	       e.addr                addr,	");
		sql.append("	       e.enter_date          enterDate,	");
		sql.append("	       e.leave_date          leaveDate,	");
		sql.append("	       e.bank_no             bankNo,	");
		sql.append("	       e.gd_bank_no          gdBankNo,	");
		sql.append("	       e.pf_bank_no          pfBankNo,	");
		sql.append("	       e.team_no             teamNo,	");
		sql.append("	       e.recommended         recommended,	");
		sql.append("	       e.dept_no             deptNo,	");
		sql.append("	       e.office_no           officeNo,	");
		sql.append("	       e.is_agreement_salary isAgreementSalary,	");
		sql.append("	       e.agreement_salary    agreementSalary,	");
		sql.append("	       e.is_formal_staff     isFormalStaff,	");
		sql.append("	       e.status              status,	");
		sql.append("	       e.create_name         createName,	");
		sql.append("	       e.create_date         createDate,	");
		sql.append("	       e.modify_name         modifyName,	");
		sql.append("	       e.modify_date         modifyDate,	");
		sql.append("	       e.emp_type            empType,	");
		sql.append("	       e.recommended_no      recommendedNo,	");
		sql.append("	       e.addr_post           addr_post,	");
		sql.append("	       e.is_cash_finance     isCashFinance,	");
		sql.append("	       e.work_org_no         workOrgNo,	");
		sql.append("	       e.salary_org_no       salaryOrgNo,	");
		sql.append("	       e.is_send_recommd     isSendRecommd,	");
		sql.append("	       e.tax_no              taxNo,	");
		sql.append("	       e.group_no            groupNo,	");
		sql.append("	       e.is_bg_manager       isBgManager,	");
		sql.append("	       e.real_name           realName,	");
		sql.append("	       e.fulltime_begin_date fulltimeBeginDate,	");
		sql.append("	       e.office_date         officeDate,	");
		sql.append("	       e.edu                 edu	");
		sql.append("	  from crf_salary_p2p_emp e	");
		sql.append("	where e.emp_no = ?");
		List<Emp> list = getJdbcTemplate().query(sql.toString(), new Object[]{empNo }, BeanPropertyRowMapper.newInstance(Emp.class));
		if(list != null){
			return list.get(0);
		}
		return null;
	}
	
	
	public List<Emp> findByEmp(Emp emp, Integer firstResult, Integer maxResults ){
		StringBuilder sql = new StringBuilder();
		sql.append("	select e.pri_number          priNumber,	");
		sql.append("	       e.emp_no              empNo,	");
		sql.append("	       e.emp_name            empName,	");
		sql.append("	       e.emp_spell           empSpell,	");
		sql.append("	       e.sex                 sex,	");
		sql.append("	       e.id_type             idType,	");
		sql.append("	       e.id_card             idCard,	");
		sql.append("	       e.marriage            marriage,	");
		sql.append("	       e.family_phone        familyPhone,	");
		sql.append("	       e.mobile_phone        mobilePhone,	");
		sql.append("	       e.eamil               eamil,	");
		sql.append("	       e.native_place        nativePlace,	");
		sql.append("	       e.addr                addr,	");
		sql.append("	       e.enter_date          enterDate,	");
		sql.append("	       e.leave_date          leaveDate,	");
		sql.append("	       e.bank_no             bankNo,	");
		sql.append("	       e.gd_bank_no          gdBankNo,	");
		sql.append("	       e.pf_bank_no          pfBankNo,	");
		sql.append("	       e.team_no             teamNo,	");
		sql.append("	       e.recommended         recommended,	");
		sql.append("	       e.dept_no             deptNo,	");
		sql.append("	       o.name             	 deptName,	");
		sql.append("	       e.office_no           officeNo,	");
		sql.append("	       office.name           officeName,	");
		sql.append("	       e.is_agreement_salary isAgreementSalary,	");
		sql.append("	       e.agreement_salary    agreementSalary,	");
		sql.append("	       e.is_formal_staff     isFormalStaff,	");
		sql.append("	       e.status              status,	");
		sql.append("	       e.create_name         createName,	");
		sql.append("	       e.create_date         createDate,	");
		sql.append("	       e.modify_name         modifyName,	");
		sql.append("	       e.modify_date         modifyDate,	");
		sql.append("	       e.emp_type            empType,	");
		sql.append("	       e.recommended_no      recommendedNo,	");
		sql.append("	       e.addr_post           addr_post,	");
		sql.append("	       e.is_cash_finance     isCashFinance,	");
		sql.append("	       e.work_org_no         workOrgNo,	");
		sql.append("	       o.name         		 orgName,	");
		sql.append("	       e.salary_org_no       salaryOrgNo,	");
		sql.append("	       e.is_send_recommd     isSendRecommd,	");
		sql.append("	       e.tax_no              taxNo,	");
		sql.append("	       e.group_no            groupNo,	");
		sql.append("	       e.is_bg_manager       isBgManager,	");
		sql.append("	       e.real_name           realName,	");
		sql.append("	       e.fulltime_begin_date fulltimeBeginDate,	");
		sql.append("	       e.office_date         officeDate,	");
		sql.append("	       e.edu                 edu	");
		sql.append("	  from crf_salary_p2p_emp e	");
		sql.append("	   inner join crf_salary_p2p_org o	");
		sql.append("	      on e.work_org_no = o.no	");
		sql.append("	   inner join crf_salary_p2p_dept d	");
		sql.append("	      on e.work_org_no = d.org_no	");
		sql.append("	     and e.dept_no = d.no	");
		sql.append("	   inner join crf_salary_p2p_office office	");
		sql.append("	      on e.work_org_no = office.org_no	");
		sql.append("	     and e.dept_no = office.dept_no	");
		sql.append("	    and e.office_no = office.no	");
		sql.append("	where 1 = 1 ");
		List<String> params = new ArrayList<String>();
		if(StringUtils.isNotBlank(emp.getEmpNo())){
			sql.append(" and e.emp_no = ?");
			params.add(emp.getEmpNo());
		}
		if(StringUtils.isNotBlank(emp.getEmpName())){
			sql.append(" and e.emp_name = ?");
			params.add(emp.getEmpName());
		}
		if(StringUtils.isNotBlank(emp.getWorkOrgNo())){
			sql.append(" and e.work_org_no = ?");
			params.add(emp.getWorkOrgNo());
		}
		sql.append("	order by e.pri_number desc ");
		
		String pageSql = PageUtil.getPageSql(sql.toString(), firstResult, maxResults);
		return this.getJdbcTemplate().query(pageSql, params.toArray(), BeanPropertyRowMapper.newInstance(Emp.class));
	}
	
	public Long countByEmp(Emp emp){
		StringBuilder sql = new StringBuilder();
		sql.append("	select count(*) ");
		sql.append("	  from crf_salary_p2p_emp e	");
		sql.append("	where 1 = 1 ");
		
		List<String> params = new ArrayList<String>();
		if(StringUtils.isNotBlank(emp.getEmpNo())){
			sql.append(" and e.emp_no = ?");
			params.add(emp.getEmpNo());
		}
		if(StringUtils.isNotBlank(emp.getEmpName())){
			sql.append(" and e.emp_name = ?");
			params.add(emp.getEmpName());
		}
		if(StringUtils.isNotBlank(emp.getWorkOrgNo())){
			sql.append(" and e.work_org_no = ?");
			params.add(emp.getWorkOrgNo());
		}
		return this.getJdbcTemplate().queryForObject(sql.toString(), params.toArray(), Long.class);
	}
	
}
