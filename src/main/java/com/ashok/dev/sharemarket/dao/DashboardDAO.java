package com.ashok.dev.sharemarket.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.ConnectionHelper;
import com.ashok.dev.sharemarket.vo.CompaniesVO;
import com.ashok.dev.sharemarket.vo.DashboardVO;

public class DashboardDAO {
	Logger logger=Logger.getLogger(DashboardDAO.class);
	public ArrayList getDashboardDetails(int userId){
		ArrayList<DashboardVO> dashboardList = new ArrayList<DashboardVO>();
		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			double walletAmount=0;
			ResultSet amountCal=stmt.executeQuery("select round(amount,2) from register_tbl where user_id="+userId);
			if(amountCal.next()){
				walletAmount=amountCal.getDouble("round(amount,2)");
			}
			
			int totalShares=0;
			Statement transactionStmt=con.createStatement();
			ResultSet tset=stmt.executeQuery("select count(*) from transactions_tbl where user_id="+userId);
			if(tset.next()){
				totalShares=tset.getInt("count(*)");
			}
			
			int boughtShares=0;
			Statement buyStmt=con.createStatement();
			ResultSet buySet=buyStmt.executeQuery("select count(*) from transactions_tbl where action='bought' and user_id="+userId);
			if(buySet.next()){
				boughtShares=buySet.getInt("count(*)");
			}
			
			
			int soldShares=0;
			Statement soldStmt=con.createStatement();
			ResultSet soldSet=soldStmt.executeQuery("select count(*) from transactions_tbl where action='sold' and user_id="+userId);
			if(soldSet.next()){
				soldShares=soldSet.getInt("count(*)");
			}
			
			
			DashboardVO userDashboard=new DashboardVO(walletAmount,totalShares,boughtShares,soldShares);
			
			dashboardList.add(userDashboard);
			amountCal.close();
			stmt.close();
			tset.close();
			transactionStmt.close();
			buySet.close();
			buyStmt.close();
			soldSet.close();
			soldStmt.close();
			con.close();
			
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getUserDashboard() Executed");
		}
		return dashboardList;
	}
}
