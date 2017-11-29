package com.ashok.dev.sharemarket.delegate;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ashok.dev.sharemarket.bo.TransactionBO;
import com.ashok.dev.sharemarket.vo.TransactionsVO;

public class TransactionDelegate {
	TransactionBO transactionBO=new TransactionBO();
	public String buyShare(TransactionsVO buyTransaction) throws SQLException{
		return transactionBO.buyShare(buyTransaction);
	}
	
	public ArrayList getAllTransactions() throws Exception{
		return transactionBO.getAllTransactions();
	}
	
	public ArrayList getTransactionDetails(int transactionId) throws Exception{
		return transactionBO.getTransactionDetails(transactionId);
	}
	
	public String sellShare(int transactionId) throws Exception{
		return transactionBO.sellShare(transactionId);
	}
	
	public ArrayList getUserTransactions(int userId) throws Exception{
		return transactionBO.getUserTransactions(userId);
	}
	
	public ArrayList getUserBoughtTransactions(int userId) throws Exception{
		return transactionBO.getUserBoughtTransactions(userId);
	}
	
	public ArrayList getUserSoldTransactions(int userId) throws Exception{
		return transactionBO.getUserSoldTransactions(userId);
	}
	
	public ArrayList getShareTransactions(int shareId) throws Exception{
		return transactionBO.getShareTransactions(shareId);
	}
	
	public ArrayList getCompanyTransactions(int comapnyId) throws Exception{
		return transactionBO.getCompanyTransactions(comapnyId);
	}
}
