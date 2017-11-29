package com.ashok.dev.sharemarket.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class CompaniesVO {
	int id;
	String companyName;
	String companyOwner;
	String companyDescription;
	double growth;
	String registeredDate;
	
	public String getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}

	public CompaniesVO(){
		
	}
	
	public CompaniesVO(int id,String companyName,String companyOwner,String companyDescription,double growth,String registeredDate){
		this.id=id;
		this.companyName=companyName;
		this.companyOwner=companyOwner;
		this.companyDescription=companyDescription;
		this.growth=growth;
		this.registeredDate=registeredDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyOwner() {
		return companyOwner;
	}
	public void setCompanyOwner(String companyOwner) {
		this.companyOwner = companyOwner;
	}
	public String getCompanyDescription() {
		return companyDescription;
	}
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
	public double getGrowth() {
		return growth;
	}
	public void setGrowth(double growth) {
		this.growth = growth;
	}
}
