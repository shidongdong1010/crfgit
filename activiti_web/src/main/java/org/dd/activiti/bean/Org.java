package org.dd.activiti.bean;

import java.io.Serializable;


public class Org implements Serializable {
    private Long priNumber ;  //唯一ID PRI_NUMBER
    private String no ;  //编号 NO
    private String name ;  //名称 NAME
    private String status ;  //状态[1:启用、2:撤销] STATUS
    private String orgDesc ;  //描述 ORG_DESC
    private String createName ;  //创建人 CREATE_NAME
    private String createDate ;  //创建时间 CREATE_DATE
    private Integer isHqPiEnter;		 // 是否总部入驻催收[1否、2是]
    
    public static final int HQ_PIENTER_FALSE = 1;
    public static final int HQ_PIENTER_TRUE = 2;

    public void setPriNumber(Long priNumber ){
        this.priNumber=priNumber;
    }
    public Long getPriNumber(){
        return this.priNumber;
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

    public void setOrgDesc(String orgDesc ){
        this.orgDesc=orgDesc;
    }
    public String getOrgDesc(){
        return this.orgDesc;
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
	public Integer getIsHqPiEnter() {
		return isHqPiEnter;
	}
	public void setIsHqPiEnter(Integer isHqPiEnter) {
		this.isHqPiEnter = isHqPiEnter;
	}
	
	/**
	 * 是否总部催收入驻
	 * @return
	 */
	public boolean isHqPiEnter(){
		if(this.isHqPiEnter.equals(Org.HQ_PIENTER_FALSE)){
			return false;
		}
		return true;
	}
}
