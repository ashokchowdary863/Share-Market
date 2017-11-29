package com.ashok.dev.sharemarket.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.ConnectionHelper;
import com.ashok.dev.sharemarket.vo.CompaniesVO;
import com.ashok.dev.sharemarket.vo.TransactionsVO;

public class TransactionDAO {
	Logger logger = Logger.getLogger(TransactionDAO.class);

	public ArrayList<TransactionsVO> getAllTransactions() throws Exception {
		ArrayList<TransactionsVO> transactionList = new ArrayList<TransactionsVO>();
		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet transactionSet = stmt
					.executeQuery("select * from transactions_tbl");
			while (transactionSet.next()) {
				String companyName = null;
				double previousPrice = 0;
				int companyId = 0;
				Statement companyStatement = con.createStatement();
				Statement sharePriceStatement = con.createStatement();

				ResultSet priceAdd = companyStatement
						.executeQuery("select * from shares_tbl where share_id="
								+ transactionSet.getInt("share_id"));
				if (priceAdd.next()) {
					previousPrice = priceAdd.getInt("current_price");
					companyId = priceAdd.getInt("company_id");
				}
				ResultSet companyAdd = companyStatement
						.executeQuery("select * from companies_tbl where company_id="
								+ companyId);
				if (companyAdd.next()) {
					companyName = companyAdd.getString("company_name");
				}

				TransactionsVO transaction = new TransactionsVO(
						transactionSet.getInt("transaction_id"),
						transactionSet.getInt("share_id"),
						transactionSet.getInt("user_id"),
						transactionSet.getInt("no_of_shares"),
						transactionSet.getDouble("growth"),
						transactionSet.getString("action"),
						transactionSet.getDouble("total_amount"),
						transactionSet.getString("performed_date"),
						companyName, transactionSet.getDouble("price_sold"),
						transactionSet.getDouble("increase_decrease"),
						transactionSet.getString("sold_date"));

				transactionList.add(transaction);
				companyStatement.close();
				companyAdd.close();
				sharePriceStatement.close();
				priceAdd.close();
			}
			transactionSet.close();

			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getAllComapnies() Executed");
		}
		return transactionList;
	}

	public ArrayList<TransactionsVO> getTransactionDetails(int transactionId)
			throws Exception {
		ArrayList<TransactionsVO> transactionDetailsList = new ArrayList<TransactionsVO>();

		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet transactionSet = stmt
					.executeQuery("select * from transactions_tbl where transaction_id="
							+ transactionId);
			while (transactionSet.next()) {
				String companyName = null;
				double previousPrice = 0;
				int companyId = 0;
				Statement companyStatement = con.createStatement();
				Statement sharePriceStatement = con.createStatement();

				ResultSet priceAdd = companyStatement
						.executeQuery("select * from shares_tbl where share_id="
								+ transactionSet.getInt("share_id"));
				if (priceAdd.next()) {
					previousPrice = priceAdd.getInt("current_price");
					companyId = priceAdd.getInt("company_id");
				}
				ResultSet companyAdd = companyStatement
						.executeQuery("select * from companies_tbl where company_id="
								+ companyId);
				if (companyAdd.next()) {
					companyName = companyAdd.getString("company_name");
				}

				TransactionsVO transaction = new TransactionsVO(
						transactionSet.getInt("transaction_id"),
						transactionSet.getInt("share_id"),
						transactionSet.getInt("user_id"),
						transactionSet.getInt("no_of_shares"),
						transactionSet.getDouble("growth"),
						transactionSet.getString("action"),
						transactionSet.getDouble("total_amount"),
						transactionSet.getString("performed_date"),
						companyName, transactionSet.getDouble("price_sold"),
						transactionSet.getDouble("increase_decrease"),
						transactionSet.getString("sold_date"));

				transactionDetailsList.add(transaction);
				companyStatement.close();
				companyAdd.close();
				sharePriceStatement.close();
				priceAdd.close();
			}
			transactionSet.close();

			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getAllComapnies() Executed");
		}

		return transactionDetailsList;
	}

	public TransactionsVO getTransactionObject(int transactionId)
			throws Exception {
		TransactionsVO transaction = null;
		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet transactionSet = stmt
					.executeQuery("select * from transactions_tbl where transaction_id="
							+ transactionId);
			if (transactionSet.next()) {

				transaction = new TransactionsVO(
						transactionSet.getInt("transaction_id"),
						transactionSet.getInt("share_id"),
						transactionSet.getInt("user_id"),
						transactionSet.getInt("no_of_shares"),
						transactionSet.getDouble("growth"),
						transactionSet.getString("action"),
						transactionSet.getDouble("total_amount"),
						transactionSet.getString("performed_date"));

			}
			transactionSet.close();

			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("TransactionObjectMethod");
		}

		return transaction;
	}

	public ArrayList<TransactionsVO> getUserTransactions(int userId)
			throws Exception {
		ArrayList<TransactionsVO> userTransactionList = new ArrayList<TransactionsVO>();

		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet transactionSet = stmt
					.executeQuery("select * from transactions_tbl where user_id="
							+ userId);
			while (transactionSet.next()) {
				String companyName = null;
				double previousPrice = 0;
				int companyId = 0;
				Statement companyStatement = con.createStatement();
				Statement sharePriceStatement = con.createStatement();

				ResultSet priceAdd = companyStatement
						.executeQuery("select * from shares_tbl where share_id="
								+ transactionSet.getInt("share_id"));
				if (priceAdd.next()) {
					previousPrice = priceAdd.getInt("current_price");
					companyId = priceAdd.getInt("company_id");
				}
				ResultSet companyAdd = companyStatement
						.executeQuery("select * from companies_tbl where company_id="
								+ companyId);
				if (companyAdd.next()) {
					companyName = companyAdd.getString("company_name");
				}

				TransactionsVO transaction = new TransactionsVO(
						transactionSet.getInt("transaction_id"),
						transactionSet.getInt("share_id"),
						transactionSet.getInt("user_id"),
						transactionSet.getInt("no_of_shares"),
						transactionSet.getDouble("growth"),
						transactionSet.getString("action"),
						transactionSet.getDouble("total_amount"),
						transactionSet.getString("performed_date"),
						companyName, transactionSet.getDouble("price_sold"),
						transactionSet.getDouble("increase_decrease"),
						transactionSet.getString("sold_date"));

				userTransactionList.add(transaction);
				companyStatement.close();
				companyAdd.close();
				sharePriceStatement.close();
				priceAdd.close();
			}
			transactionSet.close();

			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getAllComapnies() Executed");
		}
		return userTransactionList;
	}

	public ArrayList<TransactionsVO> getShareTransactions(int shareId)
			throws Exception {
		ArrayList<TransactionsVO> shareTransactionList = new ArrayList<TransactionsVO>();

		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet transactionSet = stmt
					.executeQuery("select * from transactions_tbl where share_id="
							+ shareId);
			while (transactionSet.next()) {
				String companyName = null;
				double previousPrice = 0;
				int companyId = 0;
				Statement companyStatement = con.createStatement();
				Statement sharePriceStatement = con.createStatement();

				ResultSet priceAdd = companyStatement
						.executeQuery("select * from shares_tbl where share_id="
								+ transactionSet.getInt("share_id"));
				if (priceAdd.next()) {
					previousPrice = priceAdd.getInt("current_price");
					companyId = priceAdd.getInt("company_id");
				}
				ResultSet companyAdd = companyStatement
						.executeQuery("select * from companies_tbl where company_id="
								+ companyId);
				if (companyAdd.next()) {
					companyName = companyAdd.getString("company_name");
				}

				TransactionsVO transaction = new TransactionsVO(
						transactionSet.getInt("transaction_id"),
						transactionSet.getInt("share_id"),
						transactionSet.getInt("user_id"),
						transactionSet.getInt("no_of_shares"),
						transactionSet.getDouble("growth"),
						transactionSet.getString("action"),
						transactionSet.getDouble("total_amount"),
						transactionSet.getString("performed_date"),
						companyName, transactionSet.getDouble("price_sold"),
						transactionSet.getDouble("increase_decrease"),
						transactionSet.getString("sold_date"));

				shareTransactionList.add(transaction);
				companyStatement.close();
				companyAdd.close();
				sharePriceStatement.close();
				priceAdd.close();
			}
			transactionSet.close();

			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getAllComapnies() Executed");
		}
		return shareTransactionList;
	}

	public ArrayList<TransactionsVO> getCompanyTransactions(int companyId)
			throws Exception {
		ArrayList<TransactionsVO> shareTransactionList = new ArrayList<TransactionsVO>();

		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet transactionSet = stmt
					.executeQuery("select * from transactions_tbl as t,shares_tbl as s where s.share_id=.t.share_id and s.company_id="
							+ companyId);
			while (transactionSet.next()) {

				TransactionsVO transaction = new TransactionsVO(
						transactionSet.getInt("transaction_id"),
						transactionSet.getInt("share_id"),
						transactionSet.getInt("user_id"),
						transactionSet.getInt("no_of_shares"),
						transactionSet.getDouble("growth"),
						transactionSet.getString("action"),
						transactionSet.getDouble("total_amount"),
						transactionSet.getString("performed_date"));

				shareTransactionList.add(transaction);

			}
			transactionSet.close();

			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getAllComapnies() Executed");
		}
		return shareTransactionList;
	}

	public String buyShare(TransactionsVO buyTransaction, double balance,
			int availableShares) throws SQLException {
		try {
			buyTransaction.setAction("bought");
			buyTransaction.setGrowth(0);
			int transactionId = buyTransaction.getTranscationId();
			int shareId = buyTransaction.getShareId();
			int userId = buyTransaction.getUserId();
			int noOfShares = buyTransaction.getNoOfShares();
			String action = buyTransaction.getAction();
			double growth = buyTransaction.getGrowth();
			double totalAmount = buyTransaction.getTotalAmount();
			String performedDate = buyTransaction.getPerformedDate();
			Connection con = ConnectionHelper.getConnection();
			con.setAutoCommit(false);
			java.sql.Date date = new java.sql.Date(Calendar.getInstance()
					.getTime().getTime());
			String walletQuery="insert into wallet_tbl values(null,'Used for Buying a share',?,?,?)";
			String insertTransactionquery = "insert into transactions_tbl"
					+ " VALUES" + "(null,?,?,?,?,?,?,?,null,null,null)";
			String updateUserAmountQuery = "update register_tbl set amount="
					+ balance + "where user_id=" + userId;
			String updateSharesAvailability = "update shares_tbl set no_of_shares="
					+ availableShares + " where share_id=" + shareId;
			PreparedStatement buyTransactionPreparedStatement = con
					.prepareStatement(insertTransactionquery);
			PreparedStatement amountDeductionPreparedStaement = con
					.prepareStatement(updateUserAmountQuery);
			PreparedStatement shareNumberDeductionPreparedStatement = con
					.prepareStatement(updateSharesAvailability);
			PreparedStatement walletStatement=con.prepareStatement(walletQuery);
			buyTransactionPreparedStatement.setInt(1, shareId);
			buyTransactionPreparedStatement.setInt(2, userId);
			buyTransactionPreparedStatement.setInt(3, noOfShares);
			buyTransactionPreparedStatement.setDouble(4, growth);
			buyTransactionPreparedStatement.setString(5, action);
			buyTransactionPreparedStatement.setDouble(6, totalAmount);
			buyTransactionPreparedStatement.setString(7, performedDate);
			
			walletStatement.setDouble(1, balance);
			walletStatement.setDate(2,date);
			walletStatement.setInt(3, userId);

			int transactionStatus = buyTransactionPreparedStatement
					.executeUpdate();
			int walletStatus=walletStatement.executeUpdate();
			int deductionStatus = amountDeductionPreparedStaement
					.executeUpdate();
			int shareDeductionStatus = shareNumberDeductionPreparedStatement
					.executeUpdate();
			if(walletStatus>0){
				logger.info("Wallet record inserted");
			}else {
				logger.info("Error Occured");
				return "Failed";
			}
			if (transactionStatus > 0) {
				logger.info("Trasaction inserted");
			} else {
				logger.info("Error Occured");
				return "Failed";
			}
			if (shareDeductionStatus > 0) {
				logger.info("Share Number Decreased");
			} else {
				logger.info("Error Occured");
				return "Failed";
			}
			if (deductionStatus > 0) {
				logger.info("Amount Deducted from User account");
			} else {
				logger.info("Error Occured");
				return "Failed";
			}
			con.commit();
			buyTransactionPreparedStatement.close();
			shareNumberDeductionPreparedStatement.close();
			amountDeductionPreparedStaement.close();
			con.close();
			return "Transaction Successfully Completed";
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("byShare() Executed");
		}
		return "Transaction failed";
	}

	public String sellShare(int transactionId, double soldPrice,
			double increaseDecrease, int availableShares, int shareId,
			int userId) {
		try {
			java.sql.Date date = new java.sql.Date(Calendar.getInstance()
					.getTime().getTime());
			Connection con = ConnectionHelper.getConnection();
			con.setAutoCommit(false);
			String userQuery="select * from  register_tbl where user_id="+userId;
			double walletAmount=0;
			int walletUserId=0;
			Statement st=con.createStatement();
			ResultSet rsset=st.executeQuery(userQuery);
			if(rsset.next()){
				walletAmount=rsset.getDouble("amount");
			}
			
			Statement tst=con.createStatement();
			ResultSet tstset=tst.executeQuery("select * from transactions_tbl where transaction_id="+transactionId);
			if(tstset.next()){
				walletUserId=tstset.getInt("user_id");
			}
			String walletQuery="insert into wallet_tbl values(null,'Sold a Share',?,?,?)";
			String updateUserAmountQuery = "update register_tbl set amount=amount+"
					+ soldPrice + "where user_id=" + userId;
			String updateSharesAvailability = "update shares_tbl set no_of_shares="
					+ availableShares + " where share_id=" + shareId;
			String actionUpdate = "update transactions_tbl set action='sold', price_sold=?,increase_decrease=?,sold_date=? where transaction_id="
					+ transactionId;

			PreparedStatement updateAmountStatement = con
					.prepareStatement(updateUserAmountQuery);
			PreparedStatement updateShareStatement = con
					.prepareStatement(updateSharesAvailability);
			PreparedStatement updateActionStatement = con
					.prepareStatement(actionUpdate);
			
			PreparedStatement walletStatement=con.prepareStatement(walletQuery);
			
			walletStatement.setDouble(1,walletAmount+soldPrice);
			walletStatement.setDate(2,date);
			walletStatement.setInt(3, walletUserId);
			updateActionStatement.setDouble(1, soldPrice);
			updateActionStatement.setDouble(2, increaseDecrease);
			updateActionStatement.setDate(3, date);
			int updateAmountStatus = updateAmountStatement.executeUpdate();
			int updateShareStatus = updateShareStatement.executeUpdate();
			int updateActionStatus = updateActionStatement.executeUpdate();
			int walletUpdateStatus=walletStatement.executeUpdate();
			logger.info(updateActionStatement);
			
			if(walletUpdateStatus>0){
				logger.info("Inserted in wallet table");
			}else{
				logger.info("Didint inserted in wallet table");
				return "Failed";
			}
			if (updateAmountStatus > 0) {
				logger.info("Amount Updated Successfully");
			} else {
				logger.info("Amount din't Updated Successfully");
				return "Failed";
			}
			if (updateShareStatus > 0) {
				logger.info("Availability of Shares Updated Successfully");
			} else {
				logger.info("Availability not Updated successfully");
				return "Failed";
			}
			if (updateActionStatus > 0) {
				logger.info("Status changed to sold");
			} else {
				logger.info("Status not Changed");
				return "Failed";
			}
			con.commit();
			updateAmountStatement.close();
			updateShareStatement.close();
			updateActionStatement.close();
			con.close();
			return "Transaction Successfully Completed";
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("byShare() Executed");
		}
		return "Transaction Failed";
	}

	public ArrayList<TransactionsVO> getUserBoughtTransactions(int userId)
			throws Exception {
		ArrayList<TransactionsVO> userTransactionList = new ArrayList<TransactionsVO>();

		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet transactionSet = stmt
					.executeQuery("select * from transactions_tbl where user_id="+userId+" and action='bought'");
			while (transactionSet.next()) {
				String companyName = null;
				double previousPrice = 0;
				int companyId = 0;
				Statement companyStatement = con.createStatement();
				Statement sharePriceStatement = con.createStatement();

				ResultSet priceAdd = companyStatement
						.executeQuery("select * from shares_tbl where share_id="
								+ transactionSet.getInt("share_id"));
				if (priceAdd.next()) {
					previousPrice = priceAdd.getInt("current_price");
					companyId = priceAdd.getInt("company_id");
				}
				ResultSet companyAdd = companyStatement
						.executeQuery("select * from companies_tbl where company_id="
								+ companyId);
				if (companyAdd.next()) {
					companyName = companyAdd.getString("company_name");
				}

				TransactionsVO transaction = new TransactionsVO(
						transactionSet.getInt("transaction_id"),
						transactionSet.getInt("share_id"),
						transactionSet.getInt("user_id"),
						transactionSet.getInt("no_of_shares"),
						transactionSet.getDouble("growth"),
						transactionSet.getString("action"),
						transactionSet.getDouble("total_amount"),
						transactionSet.getString("performed_date"),
						companyName, transactionSet.getDouble("price_sold"),
						transactionSet.getDouble("increase_decrease"),
						transactionSet.getString("sold_date"));

				userTransactionList.add(transaction);
				companyStatement.close();
				companyAdd.close();
				sharePriceStatement.close();
				priceAdd.close();
			}
			transactionSet.close();

			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getAllComapnies() Executed");
		}
		return userTransactionList;
	}
	public ArrayList<TransactionsVO> getUserSoldTransactions(int userId)
			throws Exception {
		logger.info("Sold Transactions userId:"+userId);
		ArrayList<TransactionsVO> userTransactionList = new ArrayList<TransactionsVO>();

		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet transactionSet = stmt
					.executeQuery("select * from transactions_tbl where user_id="
							+ userId+" and action='sold'");
			while (transactionSet.next()) {
				String companyName = null;
				double previousPrice = 0;
				int companyId = 0;
				Statement companyStatement = con.createStatement();
				Statement sharePriceStatement = con.createStatement();

				ResultSet priceAdd = companyStatement
						.executeQuery("select * from shares_tbl where share_id="
								+ transactionSet.getInt("share_id"));
				if (priceAdd.next()) {
					previousPrice = priceAdd.getInt("current_price");
					companyId = priceAdd.getInt("company_id");
				}
				ResultSet companyAdd = companyStatement
						.executeQuery("select * from companies_tbl where company_id="
								+ companyId);
				if (companyAdd.next()) {
					companyName = companyAdd.getString("company_name");
				}

				TransactionsVO transaction = new TransactionsVO(
						transactionSet.getInt("transaction_id"),
						transactionSet.getInt("share_id"),
						transactionSet.getInt("user_id"),
						transactionSet.getInt("no_of_shares"),
						transactionSet.getDouble("growth"),
						transactionSet.getString("action"),
						transactionSet.getDouble("total_amount"),
						transactionSet.getString("performed_date"),
						companyName, transactionSet.getDouble("price_sold"),
						transactionSet.getDouble("increase_decrease"),
						transactionSet.getString("sold_date"));

				userTransactionList.add(transaction);
				companyStatement.close();
				companyAdd.close();
				sharePriceStatement.close();
				priceAdd.close();
			}
			transactionSet.close();

			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getAllComapnies() Executed");
		}
		return userTransactionList;
	}
}
