package org.dd.activiti.bean;

import java.io.Serializable;

public class Emp implements Serializable {
    private Long priNumber ;  //唯一ID PRI_NUMBER
    private String empNo ;  //员工编号 EMP_NO
    private String empName ;  //员工姓名 EMP_NAME
    private String empSpell ;  //姓名拼音 EMP_SPELL
    private String sex ;  //性别[字典] SEX
    private String idType ;  //证件类型 ID_TYPE
    private String idCard ;  //证件号码 ID_CARD
    private String marriage ;  //婚姻状况[字典] MARRIAGE
    private String familyPhone ;  //家庭电话 FAMILY_PHONE
    private String mobilePhone ;  //手机 MOBILE_PHONE
    private String eamil ;  //邮箱 EAMIL
    private String nativePlace ;  //户籍所在地 NATIVE_PLACE
    private String addr ;  //现住址 ADDR
    private String enterDate ;  //入职日期 ENTER_DATE
    private String leaveDate ;  //离职日期 LEAVE_DATE
    private String bankNo ;  //银行[个人] BANK_NO
    private String gdBankNo ;  //银行卡号[个人] GD_BANK_NO
    private String pfBankNo ;  //银行卡号[浦发] PF_BANK_NO
    private String teamNo ;  //所属团队 TEAM_NO
    private String recommended ;  //推荐人 RECOMMENDED
    private String deptNo ;  //部门[字典] DEPT_NO
    private String deptName;
    private String officeNo ;  //职级[字典] OFFICE_NO
    private String officeName;
    private String isAgreementSalary ;  //是否协议工资[1:否、2:是] IS_AGREEMENT_SALARY
    private Double agreementSalary ;  //协议工资金额 AGREEMENT_SALARY
    private String isFormalStaff ;  //是否在试用期[1:是、2:否] IS_FORMAL_STAFF
    private String status ;  //状态[1:在职、2:离职] STATUS
    private String createName ;  //创建人 CREATE_NAME
    private String createDate ;  //创建时间 CREATE_DATE
    private String modifyName ;  //修改人 MODIFY_NAME
    private String modifyDate ;  //修改时间 MODIFY_DATE
    private String empType;  //人员类型[1:全日制 、2:非全日制 ] EMP_TYPE
    private String recommendedNo;  //推荐人编号 RECOMMENDED_NO
    private String addrPost;  //现住址邮编 ADDR_POST
    private String isCashFinance;  //是否兼任财务/出纳 IS_CASH_FINANCE
    private String workOrgNo;  //工作地 WORK_ORG_NO
    private String orgName;
    private String salaryOrgNo;  //工资发放地 SALARY_ORG_NO
    private String isSendRecommd;  //是否发放推荐奖[1:是、2:否] IS_SEND_RECOMMD
    private String taxNo;  //个税编号 TAX_NO
    private String groupNo;  //小组编号 GROUP_NO
    private String isBgManager;  //是否兼任后台经理[1：是、2：否] IS_BG_MANAGER
    private String realName;	//员工真实姓名 REAL_NAME
    private String fulltimeBeginDate;//全日制合同开始日期 FULLTIME_BEGIN_DATE
    private String officeDate;	//第一次到达此职级的日期 OFFICE_DATE
    private String type;		//导出员工信息类型1.全部导出 2.分页导出
    private String edu;		//学历 EDU
    
    public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOfficeDate() {
		return officeDate;
	}
	public void setOfficeDate(String officeDate) {
		this.officeDate = officeDate;
	}
	public String getFulltimeBeginDate() {
		return fulltimeBeginDate;
	}
	public void setFulltimeBeginDate(String fulltimeBeginDate) {
		this.fulltimeBeginDate = fulltimeBeginDate;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIsBgManager() {
		return isBgManager;
	}
	public void setIsBgManager(String isBgManager) {
		this.isBgManager = isBgManager;
	}
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public String getTaxNo() {
		return taxNo;
	}
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	public String getIsSendRecommd() {
		return isSendRecommd;
	}
	public void setIsSendRecommd(String isSendRecommd) {
		this.isSendRecommd = isSendRecommd;
	}
	public String getWorkOrgNo() {
		return workOrgNo;
	}
	public void setWorkOrgNo(String workOrgNo) {
		this.workOrgNo = workOrgNo;
	}
	public String getSalaryOrgNo() {
		return salaryOrgNo;
	}
	public void setSalaryOrgNo(String salaryOrgNo) {
		this.salaryOrgNo = salaryOrgNo;
	}
	public String getIsCashFinance() {
		return isCashFinance;
	}
	public void setIsCashFinance(String isCashFinance) {
		this.isCashFinance = isCashFinance;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public String getRecommendedNo() {
		return recommendedNo;
	}
	public void setRecommendedNo(String recommendedNo) {
		this.recommendedNo = recommendedNo;
	}
	public String getAddrPost() {
		return addrPost;
	}
	public void setAddrPost(String addrPost) {
		this.addrPost = addrPost;
	}
	public void setPriNumber(Long priNumber ){
        this.priNumber=priNumber;
    }
    public Long getPriNumber(){
        return this.priNumber;
    }

    public void setEmpNo(String empNo ){
        this.empNo=empNo;
    }
    public String getEmpNo(){
        return this.empNo;
    }

    public void setEmpName(String empName ){
        this.empName=empName;
    }
    public String getEmpName(){
        return this.empName;
    }

    public void setEmpSpell(String empSpell ){
        this.empSpell=empSpell;
    }
    public String getEmpSpell(){
        return this.empSpell;
    }

    public void setSex(String sex ){
        this.sex=sex;
    }
    public String getSex(){
        return this.sex;
    }

    public void setIdType(String idType ){
        this.idType=idType;
    }
    public String getIdType(){
        return this.idType;
    }

    public void setIdCard(String idCard ){
        this.idCard=idCard;
    }
    public String getIdCard(){
        return this.idCard;
    }

    public void setMarriage(String marriage ){
        this.marriage=marriage;
    }
    public String getMarriage(){
        return this.marriage;
    }

    public void setFamilyPhone(String familyPhone ){
        this.familyPhone=familyPhone;
    }
    public String getFamilyPhone(){
        return this.familyPhone;
    }

    public void setMobilePhone(String mobilePhone ){
        this.mobilePhone=mobilePhone;
    }
    public String getMobilePhone(){
        return this.mobilePhone;
    }

    public void setEamil(String eamil ){
        this.eamil=eamil;
    }
    public String getEamil(){
        return this.eamil;
    }

    public void setNativePlace(String nativePlace ){
        this.nativePlace=nativePlace;
    }
    public String getNativePlace(){
        return this.nativePlace;
    }

    public void setAddr(String addr ){
        this.addr=addr;
    }
    public String getAddr(){
        return this.addr;
    }

    public void setEnterDate(String enterDate ){
        this.enterDate=enterDate;
    }
    public String getEnterDate(){
        return this.enterDate;
    }

    public void setLeaveDate(String leaveDate ){
        this.leaveDate=leaveDate;
    }
    public String getLeaveDate(){
        return this.leaveDate;
    }

    public void setBankNo(String bankNo ){
        this.bankNo=bankNo;
    }
    public String getBankNo(){
        return this.bankNo;
    }

    public void setGdBankNo(String gdBankNo ){
        this.gdBankNo=gdBankNo;
    }
    public String getGdBankNo(){
        return this.gdBankNo;
    }

    public void setPfBankNo(String pfBankNo ){
        this.pfBankNo=pfBankNo;
    }
    public String getPfBankNo(){
        return this.pfBankNo;
    }

    public void setTeamNo(String teamNo ){
        this.teamNo=teamNo;
    }
    public String getTeamNo(){
        return this.teamNo;
    }

    public void setRecommended(String recommended ){
        this.recommended=recommended;
    }
    public String getRecommended(){
        return this.recommended;
    }

    public void setDeptNo(String deptNo ){
        this.deptNo=deptNo;
    }
    public String getDeptNo(){
        return this.deptNo;
    }

    public void setOfficeNo(String officeNo ){
        this.officeNo=officeNo;
    }
    public String getOfficeNo(){
        return this.officeNo;
    }

    public void setIsAgreementSalary(String isAgreementSalary ){
        this.isAgreementSalary=isAgreementSalary;
    }
    public String getIsAgreementSalary(){
        return this.isAgreementSalary;
    }

    public void setAgreementSalary(Double agreementSalary ){
        this.agreementSalary=agreementSalary;
    }
    public Double getAgreementSalary(){
        return this.agreementSalary;
    }

    public void setIsFormalStaff(String isFormalStaff ){
        this.isFormalStaff=isFormalStaff;
    }
    public String getIsFormalStaff(){
        return this.isFormalStaff;
    }

    public void setStatus(String status ){
        this.status=status;
    }
    public String getStatus(){
        return this.status;
    }

    public void setCreateName(String createName ){
        this.createName=createName;
    }
    public String getCreateName(){
        return this.createName;
    }

    public void setCreateDate(String createDate ){
        this.createDate=createDate;
    }
    public String getCreateDate(){
        return this.createDate;
    }

    public void setModifyName(String modifyName ){
        this.modifyName=modifyName;
    }
    public String getModifyName(){
        return this.modifyName;
    }

    public void setModifyDate(String modifyDate ){
        this.modifyDate=modifyDate;
    }
    public String getModifyDate(){
        return this.modifyDate;
    }
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}