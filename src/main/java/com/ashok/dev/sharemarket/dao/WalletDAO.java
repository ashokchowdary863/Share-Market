package com.ashok.dev.sharemarket.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.ConnectionHelper;
import com.ashok.dev.sharemarket.vo.CompaniesVO;
import com.ashok.dev.sharemarket.vo.WalletVO;

public class WalletDAO {
	Logger logger=Logger.getLogger(WalletDAO.class);
	public ArrayList<WalletVO> getAllWalletTransactions() throws Exception {
		ArrayList<WalletVO> walletList = new ArrayList<WalletVO>();
		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet list = stmt.executeQuery("select * from wallet_tbl");
			while (list.next()) {

				WalletVO wallet = new WalletVO(list.getInt("wallet_id"),
						list.getInt("user_id"),
						list.getString("reason"),
						list.getDouble("amount"),
						list.getString("modified_date")
						);
						
				walletList.add(wallet);

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
		return walletList;
	}
	
	public ArrayList<WalletVO> getUserWalletTransactions(int userId) throws Exception {
		ArrayList<WalletVO> walletList = new ArrayList<WalletVO>();
		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet list = stmt.executeQuery("select * from wallet_tbl where user_id="+userId);
			while (list.next()) {

				WalletVO wallet = new WalletVO(list.getInt("wallet_id"),
						list.getInt("user_id"),
						list.getString("reason"),
						list.getDouble("amount"),
						list.getString("modified_date")
						);
						
				walletList.add(wallet);

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
		return walletList;
	}
}
