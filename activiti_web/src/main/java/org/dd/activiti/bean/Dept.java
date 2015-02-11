package org.dd.activiti.bean;

import java.io.Serializable;


public class Dept implements Serializable {
    private Long priNumber ;  //唯一ID PRI_NUMBER
    private String orgNo ;  //分公司 ORG_NO
    private String no ;  //部门编号 NO
    private String name ;  //部门名称 NAME
    private String status ;  //状态[1:启用、2:撤销] STATUS
    private String deptDesc ;  //描述 DEPT_DESC
    private String createName ;  //创建人 CREATE_NAME
    private String createDate ;  //创建时间 CREATE_DATE

    public void setPriNumber(Long priNumber ){
        this.priNumber=priNumber;
    }
    public Long getPriNumber(){
        return this.priNumber;
    }

    public void setOrgNo(String orgNo ){
        this.orgNo=orgNo;
    }
    public String getOrgNo(){
        return this.orgNo;
    }

    public void setNo(String no ){
        this.no=no;
    }
    public String getNo(){
        return this.no;
    }

    public void setName(String name ){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public void setStatus(String status ){
        this.status=status;
    }
    public String getStatus(){
        return this.status;
    }

    public void setDeptDesc(String deptDesc ){
        this.deptDesc=deptDesc;
    }
    public String getDeptDesc(){
        return this.deptDesc;
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

}