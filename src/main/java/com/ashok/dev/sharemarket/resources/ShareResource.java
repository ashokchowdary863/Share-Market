package com.ashok.dev.sharemarket.resources;

import java.sql.SQLException;
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

import com.ashok.dev.sharemarket.delegate.ShareDelegate;
import com.ashok.dev.sharemarket.vo.SharesVO;
import com.google.gson.Gson;

@Path("/shares")
public class ShareResource {
	Logger logger=Logger.getLogger(ShareResource.class);
	Gson gson=new Gson();
	ShareDelegate shareDelegate=new ShareDelegate();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllShares(){
		
		String shares=null;
		try{
			ArrayList<SharesVO> shareList=null;
			shareList=shareDelegate.getAllShares();
			Gson gson=new Gson();
			logger.info(gson.toJson(shareList));
			shares=gson.toJson(shareList);
		}catch(Exception e){
			logger.error(e);
		}
		return shares;
	}
	
	@Path("/{shareId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCompanyDetails(@PathParam("shareId") int shareId){
		String shareData=null;
		try{
			ArrayList<SharesVO> shareDataList=shareDelegate.getShareDetails(shareId);
			
			
			logger.info(gson.toJson(shareDataList));
			shareData=gson.toJson(shareDataList);
		}catch(Exception e){
			logger.error(e);
		}
		return shareData;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SharesVO addShare(SharesVO newShareData) throws SQLException{
		 return shareDelegate.addShare(newShareData);
	}
	
	@Path("/{shareId}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SharesVO updateShareDetails(@PathParam("shareId") int companyId,SharesVO shareData){
		shareDelegate.updateShareDetails(companyId,shareData);
		return shareData;
	}
	
	@Path("/{shareId}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteShare(@PathParam("shareId") int shareId){
		shareDelegate.deleteShare(shareId);
	}
	
	
}
