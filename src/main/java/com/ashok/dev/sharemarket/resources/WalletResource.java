package com.ashok.dev.sharemarket.resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.delegate.WalletDelegate;
import com.ashok.dev.sharemarket.vo.CompaniesVO;
import com.ashok.dev.sharemarket.vo.WalletVO;
import com.google.gson.Gson;

@Path("/wallet")
public class WalletResource {
	WalletDelegate walletDelegate=new WalletDelegate();
	Logger logger=Logger.getLogger(WalletResource.class);
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllWalletTransactions(){
		String wallets=null;
		try{
			ArrayList<WalletVO> walletList=null;
			walletList=walletDelegate.getAllWalletTransactions();
			Gson gson=new Gson();
			logger.info(gson.toJson(walletList));
			wallets=gson.toJson(walletList);
		}catch(Exception e){
			logger.error(e);
		}
		return wallets;
	}
	
	@Path("/users/{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserWalletTransactions(@PathParam("userId") int userId){
		String userWalletData=null;
		try{
			ArrayList<WalletVO> userWalletList=walletDelegate.getUserWalletTransactions(userId);
			Gson gson=new Gson();
			logger.info(gson.toJson(userWalletList));
			userWalletData=gson.toJson(userWalletList);
		}catch(Exception e){
			logger.error(e);
		}finally{
			logger.info("getUserWalletTransactions() executed");
		}
		return userWalletData;
	}
	
}
