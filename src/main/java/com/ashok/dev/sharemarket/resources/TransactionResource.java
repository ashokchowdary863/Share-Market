package com.ashok.dev.sharemarket.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.delegate.TransactionDelegate;
import com.ashok.dev.sharemarket.vo.CompaniesVO;
import com.ashok.dev.sharemarket.vo.TransactionsVO;
import com.google.gson.Gson;

@Path("/transactions")
public class TransactionResource {
	TransactionDelegate transactionDelegate=new TransactionDelegate();
	Logger logger=Logger.getLogger(TransactionResource.class);
	Gson gson=new Gson();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllTransactions(){
		String transactions=null;
		try{
			ArrayList<TransactionsVO> transactionList=null;
			transactionList=transactionDelegate.getAllTransactions();
			Gson gson=new Gson();
			logger.info(gson.toJson(transactionList));
			transactions=gson.toJson(transactionList);
		}catch(Exception e){
			logger.error(e);
		}
		return transactions;
	}
	
	@Path("/{transactionId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTransactionDetails(@PathParam("transactionId") int transactionId){
		String transactionData=null;
		try{
			ArrayList<TransactionsVO> transactionDataList=transactionDelegate.getTransactionDetails(transactionId);
			
			
			logger.info(gson.toJson(transactionDataList));
			transactionData=gson.toJson(transactionDataList);
		}catch(Exception e){
			logger.error(e);
		}
		return transactionData;
	}
	
	@Path("/users/{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserTransactions(@PathParam("userId") int userId){
		String userTransactionData=null;
		try{
			ArrayList<TransactionsVO> userTransactionList=transactionDelegate.getUserTransactions(userId);
			
			
			logger.info(gson.toJson(userTransactionList));
			userTransactionData=gson.toJson(userTransactionList);
		}catch(Exception e){
			logger.error(e);
		}
		return userTransactionData;
	}
	
	@Path("/users/{userId}/buy")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserBoughtTransactions(@PathParam("userId") int userId){
		String userTransactionData=null;
		try{
			ArrayList<TransactionsVO> userTransactionList=transactionDelegate.getUserBoughtTransactions(userId);
			
			
			logger.info(gson.toJson(userTransactionList));
			userTransactionData=gson.toJson(userTransactionList);
		}catch(Exception e){
			logger.error(e);
		}
		return userTransactionData;
	}
	
	@Path("/users/{userId}/sold")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserSoldTransactions(@PathParam("userId") int userId){
		String userTransactionData=null;
		try{
			ArrayList<TransactionsVO> userTransactionList=transactionDelegate.getUserSoldTransactions(userId);
			
			
			logger.info(gson.toJson(userTransactionList));
			userTransactionData=gson.toJson(userTransactionList);
		}catch(Exception e){
			logger.error(e);
		}
		return userTransactionData;
	}
	
	@Path("/shares/{shareId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getShareTransactions(@PathParam("shareId") int userId){
		String shareTransactionData=null;
		try{
			ArrayList<TransactionsVO> shareTransactionList=transactionDelegate.getShareTransactions(userId);
			
			
			logger.info(gson.toJson(shareTransactionList));
			shareTransactionData=gson.toJson(shareTransactionList);
		}catch(Exception e){
			logger.error(e);
		}
		return shareTransactionData;
	}
	
	@Path("/companies/{companyId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCompanyTransactions(@PathParam("companyId") int companyId){
		String companyTransactionData=null;
		try{
			ArrayList<TransactionsVO> companyTransactionList=transactionDelegate.getCompanyTransactions(companyId);
			
			
			logger.info(gson.toJson(companyTransactionList));
			companyTransactionData=gson.toJson(companyTransactionList);
		}catch(Exception e){
			logger.error(e);
		}
		return companyTransactionData;
	}
	
	
	@POST
	@Path("/buy")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String buyShare(TransactionsVO buyTransaction) throws SQLException{
		return transactionDelegate.buyShare(buyTransaction);
		
	}
	
	@POST
	@Path("/sell/{transactionId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String sellShare(@PathParam("transactionId") int transactionId) throws Exception{
		return transactionDelegate.sellShare(transactionId);
	}
}
