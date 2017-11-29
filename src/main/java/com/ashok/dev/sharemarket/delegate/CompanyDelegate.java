package com.ashok.dev.sharemarket.delegate;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.CompaniesBO;
import com.ashok.dev.sharemarket.vo.CompaniesVO;

public class CompanyDelegate {
	CompaniesBO companiesBO=new CompaniesBO();
	Logger logger=Logger.getLogger(CompanyDelegate.class);
	public ArrayList getAllCompanies() throws Exception{
		return companiesBO.getAllCompanies();
	}
	
	public ArrayList getCompanyDetails(int companyId) throws Exception{
		return companiesBO.getCompanyDetails(companyId);
	}
	
	public CompaniesVO addCompany(CompaniesVO newCompanyData){
		
		logger.info("addCompany() CompanyDelegate Executed");
		return companiesBO.addCompany(newCompanyData);
	}
	
	public void updateCompanyDetails(int companyId,CompaniesVO companyData){
		companiesBO.updateCompanyDetails(companyId,companyData);
		logger.info("updateCompanyDetails() CompanyDelegate Executed");
	}
	
	public void deleteCompany(int companyId){
		companiesBO.deleteCompany(companyId);
		logger.info("deleteCompany() CompanyDelegateExecuted");
	}
}	
