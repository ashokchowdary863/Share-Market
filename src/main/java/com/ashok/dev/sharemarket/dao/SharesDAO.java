package com.ashok.dev.sharemarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.CompaniesBO;
import com.ashok.dev.sharemarket.bo.ConnectionHelper;
import com.ashok.dev.sharemarket.vo.CompaniesVO;
import com.ashok.dev.sharemarket.vo.SharesVO;

public class SharesDAO {
	Logger logger = Logger.getLogger(SharesDAO.class);

	public ArrayList<SharesVO> getAllShares() throws Exception {
		ArrayList<SharesVO> sharesList = new ArrayList<SharesVO>();
		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet list = stmt.executeQuery("select * from shares_tbl");
			while (list.next()) {
				String companyName = null;
				Statement companyStatement = con.createStatement();
				ResultSet companyAdd = companyStatement
						.executeQuery("select * from companies_tbl where company_id="
								+ list.getInt("company_id"));
				if (companyAdd.next()) {
					companyName = companyAdd.getString("company_name");
				}
				SharesVO company = new SharesVO(list.getInt("share_id"),
						list.getInt("company_id"), companyName,
						list.getDouble("current_price"),
						list.getDouble("previous_price"),
						list.getDouble("increase_decrease"),
						list.getInt("no_of_shares"),
						list.getString("announced_date"),
						list.getDouble("brokerage_percentage")

				);

				sharesList.add(company);
				companyStatement.close();
				companyAdd.close();
			}

			list.close();
			stmt.close();
			con.close();

		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {

			logger.info("getAllShares() Executed");
		}
		return sharesList;
	}

	public ArrayList<SharesVO> getShareDetails(int shareId) throws Exception {
		ArrayList<SharesVO> sharesList = new ArrayList<SharesVO>();
		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet list = stmt
					.executeQuery("select * from shares_tbl where share_id="
							+ shareId);
			while (list.next()) {
				String companyName = null;
				Statement companyStatement = con.createStatement();
				ResultSet companyAdd = companyStatement
						.executeQuery("select * from companies_tbl where company_id="
								+ list.getInt("company_id"));
				if (companyAdd.next()) {
					companyName = companyAdd.getString("company_name");
				}
				SharesVO company = new SharesVO(list.getInt("share_id"),
						list.getInt("company_id"), companyName,
						list.getDouble("current_price"),
						list.getDouble("previous_price"),
						list.getDouble("increase_decrease"),
						list.getInt("no_of_shares"),
						list.getString("announced_date"),
						list.getDouble("brokerage_percentage")

				);

				sharesList.add(company);
				companyStatement.close();
				companyAdd.close();
			}
			list.close();
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
		return sharesList;
	}

	public SharesVO addShare(SharesVO newShareData) {
		try {
			int companyId = newShareData.getCid();
			double currentPrice = newShareData.getCurrentSharePrice();
			double previousPrice = newShareData.getPreviousSharePrice();
			double increaseDecrease = newShareData.getIncreaseDecrease();
			int noOfShares = newShareData.getNoOfShares();
			String date = newShareData.getAnnouncedDate();
			double brokeragePercentage = newShareData.getBrokeragePercentage();
			int status = 0;
			Connection con = ConnectionHelper.getConnection();
			String query = "insert into shares_tbl" + " VALUES"
					+ "(null,?,?,?,?,?,?,?)";
			con.setAutoCommit(true);
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, companyId);
			st.setDouble(2, currentPrice);
			st.setDouble(3, previousPrice);
			st.setDouble(4, increaseDecrease);
			st.setInt(5, noOfShares);
			st.setString(6, date);
			st.setDouble(7, brokeragePercentage);
			status = st.executeUpdate();
			if (status > 0) {
				logger.info("Share Registered Successfully...");
			} else
				logger.info("Error Occured");
			st.close();
			con.close();
			return newShareData;
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("addShare() ShareDAO Executed");
		}
		return null;
	}

	public void updateShareDetails(int shareId, SharesVO newShareData) {

		int companyId = newShareData.getCid();
		double currentPrice = newShareData.getCurrentSharePrice();
		double previousPrice = newShareData.getPreviousSharePrice();
		double increaseDecrease = newShareData.getIncreaseDecrease();
		int noOfShares = newShareData.getNoOfShares();
		String date = newShareData.getAnnouncedDate();
		double brokeragePercentage = newShareData.getBrokeragePercentage();
		try {
			int status = 0;
			Connection con = ConnectionHelper.getConnection();
			String updateQuery = "update shares_tbl set company_id=?,current_price=?,previous_price=?,increase_decrease=?,no_of_shares=? ,brokerage_percentage=?  where share_id="
					+ shareId;
			con.setAutoCommit(true);
			PreparedStatement st = con.prepareStatement(updateQuery);
			st.setInt(1, companyId);
			st.setDouble(2, currentPrice);
			st.setDouble(3, previousPrice);
			st.setDouble(4, increaseDecrease);
			st.setInt(5, noOfShares);
			st.setDouble(6, brokeragePercentage);

			logger.info(updateQuery);

			status = st.executeUpdate();
			if (status > 0) {
				logger.info("Share information Updated successfully");
			} else
				logger.info("Error Occured");
			st.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("updateShareDetails() ShareDAO Executed");
		}

	}

	public void deleteShare(int shareId) {
		try {
			Connection con = ConnectionHelper.getConnection();
			con.setAutoCommit(true);
			String query = "delete from shares_tbl where share_id=" + shareId;
			Statement st = con.createStatement();
			st.executeUpdate(query);
			logger.info("Share Deleted Successfully");
			st.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("deleteShare() CompanyDAO method Executed");
		}
	}
	public void changeSharePrice(){
		try{
			Connection connection=ConnectionHelper.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from shares_tbl");
			connection.setAutoCommit(false);
			while(resultSet.next()){
				Random r = new Random();
				double randomValue = -0.01 + (0.01 - (-0.01)) * r.nextDouble();
				double currentPrice=resultSet.getDouble("current_price")+resultSet.getDouble("current_price")*randomValue;
				//logger.info("Current Price:"+currentPrice);
				String updateQuery="update shares_tbl set previous_price="+resultSet.getDouble("current_price")+", current_price="+currentPrice+"where share_id="+resultSet.getInt("share_id");
				Statement updateStatement=connection.createStatement();
				int status=updateStatement.executeUpdate(updateQuery);
				//logger.info(updateQuery);
				if(status>0){
					logger.info(resultSet.getInt("share_id")+" share price Updated");
				}else{
					logger.info(resultSet.getInt("share_id")+" share price not Updated");
				}
				updateStatement.close();
			}
			Statement boughtSharePriceStmt=connection.createStatement();
			ResultSet boughtPriceUpdate=boughtSharePriceStmt.executeQuery("select * from transactions_tbl");
			while(boughtPriceUpdate.next()){
				Random r = new Random();
				double randomValue = -0.01 + (0.01 - (-0.01)) * r.nextDouble();
				String updateQuery="update transactions_tbl set growth=growth+"+boughtPriceUpdate.getDouble("total_amount")*randomValue+" where transaction_id="+boughtPriceUpdate.getInt("transaction_id");
				Statement updateStatement=connection.createStatement();
				int status=updateStatement.executeUpdate(updateQuery);
				//logger.info(updateQuery);
				if(status>0){
					logger.info(boughtPriceUpdate.getInt("transaction_id")+" transaction  price Updated");
				}else{
					logger.info(boughtPriceUpdate.getInt("share_id")+" transaction  price not Updated");
				}
				updateStatement.close();
			}
			connection.commit();
			boughtPriceUpdate.close();
			boughtSharePriceStmt.close();
			
			resultSet.close();
			statement.close();
			connection.close();
		}catch(NullPointerException e){
			logger.error("NullPointer Exception:"+e);
		}catch(Exception e){
			logger.error("Exception:"+e);
		}
	}
}
