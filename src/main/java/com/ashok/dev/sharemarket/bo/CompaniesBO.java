package com.ashok.dev.sharemarket.bo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.dao.CompaniesDAO;
import com.ashok.dev.sharemarket.vo.CompaniesVO;

public class CompaniesBO {
	CompaniesDAO companiesDAO=new CompaniesDAO();
	Logger logger=Logger.getLogger(CompaniesBO.class);
	public ArrayList getAllCompanies() throws Exception{
		return companiesDAO.getAllCompanies();
	}
	
	public ArrayList getCompanyDetails(int companyId) throws Exception{
		return companiesDAO.getCompanyDetails(companyId);
	}
	
	public CompaniesVO addCompany(CompaniesVO newCompanyData){
		
		logger.info("addCompany() CompaniesBO Executed");
		return companiesDAO.addCompany(newCompanyData);
	}
	
	public void updateCompanyDetails(int companyId,CompaniesVO newCompanyData){
		companiesDAO.updateCompanyDetails(companyId,newCompanyData);
		logger.info("updateCompanyDetails() CompaniesBO Executed");
	}
	
	public void deleteCompany(int companyId){
		companiesDAO.deleteCompany(companyId);
		logger.info("deleteComapny() CompaniesBO Executed");
	}
}
