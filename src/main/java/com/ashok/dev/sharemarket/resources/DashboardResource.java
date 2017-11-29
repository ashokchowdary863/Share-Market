package com.ashok.dev.sharemarket.resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.delegate.DashboardDelegate;
import com.ashok.dev.sharemarket.vo.CompaniesVO;
import com.ashok.dev.sharemarket.vo.DashboardVO;
import com.google.gson.Gson;

@Path("/dashboard")
public class DashboardResource {
	Logger logger=Logger.getLogger(DashboardResource.class);
	Gson gson=new Gson();
	DashboardDelegate dashboardDelegate=new DashboardDelegate();
	@Path("/{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getDashboardDetails(@PathParam("userId") int userId){
		String dashboardData=null;
		try{
			ArrayList<DashboardVO> dashboardList=null;
			dashboardList=dashboardDelegate.getDashboardDetails(userId);
			Gson gson=new Gson();
			logger.info(gson.toJson(dashboardList));
			dashboardData=gson.toJson(dashboardList);
		}catch(Exception e){
			logger.error(e);
		}
		return dashboardData;
	}
}
