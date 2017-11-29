package com.ashok.dev.sharemarket.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.CompaniesBO;
import com.ashok.dev.sharemarket.delegate.CompanyDelegate;
import com.ashok.dev.sharemarket.vo.CompaniesVO;
import com.ashok.dev.sharemarket.vo.UsersVO;
import com.google.gson.Gson;

@Path("/companies")
public class CompanyResource {
	Logger logger=Logger.getLogger(CompanyResource.class);
	Gson gson=new Gson();
	CompanyDelegate companyDelegate=new CompanyDelegate();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCompanies(){
		String companies=null;
		try{
			ArrayList<CompaniesVO> companiesList=null;
			companiesList=companyDelegate.getAllCompanies();
			Gson gson=new Gson();
			logger.info(gson.toJson(companiesList));
			companies=gson.toJson(companiesList);
		}catch(Exception e){
			logger.error(e);
		}
		return companies;
	}
	
	@Path("/{companyId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCompanyDetails(@PathParam("companyId") int companyId){
		String companyData=null;
		try{
			ArrayList<CompaniesVO> companyDataList=companyDelegate.getCompanyDetails(companyId);
			
			
			logger.info(gson.toJson(companyDataList));
			companyData=gson.toJson(companyDataList);
		}catch(Exception e){
			logger.error(e);
		}
		return companyData;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CompaniesVO addCompany(CompaniesVO newCompanyData){
		 
		 return companyDelegate.addCompany(newCompanyData);
	}
	
	@Path("/{companyId}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCompany(@PathParam("companyId") int companyId,CompaniesVO companyData){
		companyDelegate.updateCompanyDetails(companyId,companyData);
		return Response.ok().entity("").build();
	}
	
	@Path("/{companyId}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCompany(@PathParam("companyId") int companyId){
		companyDelegate.deleteCompany(companyId);
	}
	
	
}
