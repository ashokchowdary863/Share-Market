package com.ashok.dev.sharemarket.bo;

import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.dao.TransactionDAO;
import com.ashok.dev.sharemarket.vo.TransactionsVO;

public class TransactionBO {
	Logger logger = Logger.getLogger(TransactionBO.class);
	TransactionDAO transactionDAO=new TransactionDAO();
	
	public ArrayList getAllTransactions() throws Exception{
		return transactionDAO.getAllTransactions();
	}
	
	public ArrayList getTransactionDetails(int transactionId) throws Exception{
		return transactionDAO.getTransactionDetails(transactionId);
	}
	
	public ArrayList getUserTransactions(int userId) throws Exception{
		return transactionDAO.getUserTransactions(userId);
	}
	
	
	public ArrayList getUserBoughtTransactions(int userId) throws Exception{
		return transactionDAO.getUserBoughtTransactions(userId);
	}
	
	

	public ArrayList getUserSoldTransactions(int userId) throws Exception{
		return transactionDAO.getUserSoldTransactions(userId);
	}
	
	public ArrayList getShareTransactions(int shareId) throws Exception{
		return transactionDAO.getShareTransactions(shareId);
	}
	
	public ArrayList getCompanyTransactions(int companyId) throws Exception{
		return transactionDAO.getCompanyTransactions(companyId);
	}
	
	public String buyShare(TransactionsVO buyTransaction) throws SQLException {
		try {
			int shareId=buyTransaction.getShareId();
			int userId=buyTransaction.getUserId();
			int noOfShares=buyTransaction.getNoOfShares();
			double brokeragePercentage=0;
			double price=0;
			int noOfSharesAvailable=0;
			Connection connection = ConnectionHelper.getConnection();
			Statement shareStatement=connection.createStatement();
			ResultSet shareSet = shareStatement.executeQuery("select * from shares_tbl where share_id="+shareId);
			if(shareSet.next()){
				brokeragePercentage=shareSet.getDouble("brokerage_percentage");
				price=shareSet.getDouble("current_price");
				noOfSharesAvailable=shareSet.getInt("no_of_shares");
			}else{
				return "Sorry...We are unable to process your request";
			}
			
			if(noOfSharesAvailable<noOfShares){
				return "Sorry...That much shares are not available with this company";
			}
			int availableShares=noOfSharesAvailable-noOfShares;
			logger.info(availableShares);
			shareSet.close(); 
			double amount=(((noOfShares*price))*(100+brokeragePercentage)/100);
			logger.info(amount);
			Statement userStatement=connection.createStatement();
			ResultSet userSet=userStatement.executeQuery("select * from register_tbl where user_id="+userId);
			double userAmount=0;
			if(userSet.next()){
				userAmount=userSet.getDouble("amount");
			}
			else{
				return "unable to process your request at this time";
			}
			logger.info(userAmount);
			if(userAmount<amount){
				return "Insufficinet funds to buy the share";
			}
			double balance=userAmount-amount;
			buyTransaction.setTotalAmount(amount);
			shareSet.close();
			shareStatement.close();
			connection.close();
			return transactionDAO.buyShare(buyTransaction,balance,availableShares);
			
		}catch (NullPointerException ne) {
			logger.error("NullPointerException : " + ne);
		} catch (Exception e) {
			logger.error("Exception : " + e);
		} finally {
			logger.info("TransactionBo: buyShare() method executed");
		}
		return null;
	}
	public String sellShare(int transactionId) throws Exception{
		
		try{
			int shareId=0;
			int userId=0;
			int noOfShares=0;
			double growth=0;
			double priceAtBuy=0;
			double brokeragePercentage=0;
			double previousAmount=0;
			String status=null;
			int availableShares=0;
			Connection connection = ConnectionHelper.getConnection();
			Statement shareStatement=connection.createStatement();
			Statement amountGrowth=connection.createStatement();
			ResultSet amountSet=amountGrowth.executeQuery("select * from transactions_tbl where transaction_id="+transactionId);
			if(amountSet.next()){
				previousAmount=amountSet.getDouble("total_amount");
				userId=amountSet.getInt("user_id");
				shareId=amountSet.getInt("share_id");
				growth=amountSet.getDouble("growth");
				noOfShares=amountSet.getInt("no_of_shares");
				status=amountSet.getString("action");
			}
			logger.info(userId+"\n"+shareId+"\n"+previousAmount+"\n"+growth+"\n"+transactionId);
			double priceAtSell=((previousAmount)+(growth*noOfShares))/noOfShares;
			ResultSet shareSet = shareStatement.executeQuery("select * from shares_tbl where share_id="+shareId);
			if(status.equals("sold")){
				return "This share is already sold";
			}
			if(shareSet.next()){
				brokeragePercentage=shareSet.getDouble("brokerage_percentage");
				priceAtBuy=shareSet.getInt("current_price");
				availableShares=shareSet.getInt("no_of_shares");
			}
			
			availableShares=availableShares+noOfShares;
			
			double amount=((priceAtSell*noOfShares)*((100-brokeragePercentage))/100);
			double increaseDecrease=amount-previousAmount;
			logger.info("Price at sell:"+priceAtSell);
			logger.info("selling amount:"+amount);
			logger.info("Profit :"+increaseDecrease);
			amountSet.close();
			shareSet.close();
			shareStatement.close();
			connection.close();
			return transactionDAO.sellShare(transactionId,amount,increaseDecrease,availableShares,shareId,userId);

		}catch (NullPointerException ne) {
			logger.error("NullPointerException : " + ne);
		} catch (Exception e) {
			logger.error("Exception : " + e);
		} finally {
			logger.info("TransactionBo: sellShare() method executed");
		}
		return null;

	}
}
