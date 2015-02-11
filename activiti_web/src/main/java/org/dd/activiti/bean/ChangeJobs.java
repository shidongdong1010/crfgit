package org.dd.activiti.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 职位变动
 * @author SDD
 *
 * 2014年8月3日
 */
@Entity
@Table(name = "CRF_SALARY_P2P_CHANGE_JOBS")
public class ChangeJobs implements Serializable {

	@Column(name = "PRI_NUMBER")
	private Long priNumber;
	
	@Column(name = "EMP_NO")
	private String empNo;
	
	@Column(name = "EMP_NAME")
	private String empName;
	
	@Column(name = "OLD_ORG_NO")
	private String oldOrgNo;		// 老公司
	
	@Column(name = "OLD_DEPT_NO")
	private String oldDeptNo;		// 老部门
	
	@Column(name = "OLD_OFFICE_NO")
	private String oldOfficeNo;		// 老职位
	
	@Column(name = "NEW_ORG_NO")
	private String newOrgNo;		// 新公司
	
	@Column(name = "NEW_DEPT_NO")
	private String newDeptNo;		// 新部门
	
	@Column(name = "NEW_OFFICE_NO")
	private String newOfficeNo;		// 新职位
	
	@Column(name = "EFFECTIVE_DATE")
	private String effectiveDate;	// 生效日期
	
	@Column(name = "STATUS")
	private Integer status;			// 状态[0正确， 1删除]
	
	@Column(name = "CREATE_DATE")
	private String createDate;		// 创建日期
	
	@Column(name = "CREATE_NAME")
	private String createName;		// 创建人
	
	public Long getPriNumber() {
		return priNumber;
	}
	public void setPriNumber(Long priNumber) {
		this.priNumber = priNumber;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getOldOrgNo() {
		return oldOrgNo;
	}
	public void setOldOrgNo(String oldOrgNo) {
		this.oldOrgNo = oldOrgNo;
	}
	public String getOldDeptNo() {
		return oldDeptNo;
	}
	public void setOldDeptNo(String oldDeptNo) {
		this.oldDeptNo = oldDeptNo;
	}
	public String getOldOfficeNo() {
		return oldOfficeNo;
	}
	public void setOldOfficeNo(String oldOfficeNo) {
		this.oldOfficeNo = oldOfficeNo;
	}
	public String getNewOrgNo() {
		return newOrgNo;
	}
	public void setNewOrgNo(String newOrgNo) {
		this.newOrgNo = newOrgNo;
	}
	public String getNewDeptNo() {
		return newDeptNo;
	}
	public void setNewDeptNo(String newDeptNo) {
		this.newDeptNo = newDeptNo;
	}
	public String getNewOfficeNo() {
		return newOfficeNo;
	}
	public void setNewOfficeNo(String newOfficeNo) {
		this.newOfficeNo = newOfficeNo;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
}
