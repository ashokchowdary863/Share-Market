package com.ashok.dev.sharemarket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;

import org.apache.log4j.Logger;
import org.hsqldb.rights.User;

import com.ashok.dev.sharemarket.bo.ConnectionHelper;
import com.ashok.dev.sharemarket.vo.UsersVO;

public class UserDAO {
	Logger logger = Logger.getLogger(UserDAO.class);
	ArrayList<UsersVO> userList = new ArrayList<UsersVO>();

	public ArrayList<UsersVO> getAllUsers() throws Exception {
		ArrayList<UsersVO> userList = new ArrayList<UsersVO>();
		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet list = stmt.executeQuery("select * from register_tbl");
			while (list.next()) {

				UsersVO newUser = new UsersVO(list.getInt("user_id"),
						list.getString("username"),
						list.getString("firstname"),
						list.getString("lastname"), list.getString("email"),
						list.getString("mobile"),
						list.getString("bank_account_no"),
						list.getString("pan_no"), list.getDouble("amount"),
						list.getString("state"), list.getString("country"),
						list.getString("zipcode"), list.getString("role"),
						list.getString("registered_date"));
				userList.add(newUser);

			}
			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getAllUsersMethod() Executed");
		}
		return userList;
	}

	public UsersVO addUser(UsersVO user) {

		try {
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

			String uname = user.getCustomerUserName();
			String fname = user.getCustomerFirstName();
			String lname = user.getCustomerLastName();
			String pwd = user.getCustomerPassword();
			String email = user.getCustomerEmail();
			String mobile = user.getCustomerMobile();
			String account = user.getBankAccountNumber();
			String pan_no = user.getCustomerPan();
			double amount = 100000;
			user.setRole("customer");
			String state = user.getCustomerState();
			String country = user.getCustomerCountry();
			String zipcode = user.getCustomerZipCode();
			String role ="customer";

			int status = 0;
			Connection con = ConnectionHelper.getConnection();
			String query = "insert into register_tbl" + " VALUES"
					+ "(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			con.setAutoCommit(true);
			PreparedStatement st = con.prepareStatement(query);

			st.setString(1, uname);
			st.setString(2, fname);
			st.setString(3, lname);
			st.setString(4, pwd);
			st.setString(5, email);
			st.setString(6, mobile);
			st.setString(7, account);
			st.setString(8, pan_no);
			st.setDouble(9, amount);
			st.setString(10, state);
			st.setString(11, country);
			st.setString(12, zipcode);
			st.setString(13, role);
			st.setDate(14, date);
			;
			status = st.executeUpdate();
			if (status > 0) {
				logger.info("User inserted Successfully");
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
			logger.info("addUser() Executed");
		}
		return user;
	}
	public UsersVO addGoogleUser(UsersVO user) {

		try {
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

			String uname = user.getCustomerUserName();
			String fname = user.getCustomerFirstName();
			String lname = user.getCustomerLastName();
			String pwd = user.getCustomerPassword();
			String email = user.getCustomerEmail();
			String mobile = user.getCustomerMobile();
			String account = user.getBankAccountNumber();
			String pan_no = user.getCustomerPan();
			double amount = 100000;
			user.setRole("customer");
			String state = user.getCustomerState();
			String country = user.getCustomerCountry();
			String zipcode = user.getCustomerZipCode();
			String role ="customer";

			int status = 0;
			Connection con = ConnectionHelper.getConnection();
			String query = "insert into register_tbl" + " VALUES"
					+ "(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			con.setAutoCommit(true);
			PreparedStatement st = con.prepareStatement(query);

			st.setString(1, uname);
			st.setString(2, fname);
			st.setString(3, lname);
			st.setString(4, pwd);
			st.setString(5, email);
			st.setString(6, mobile);
			st.setString(7, account);
			st.setString(8, pan_no);
			st.setDouble(9, amount);
			st.setString(10, state);
			st.setString(11, country);
			st.setString(12, zipcode);
			st.setString(13, role);
			st.setDate(14, date);
			;
			status = st.executeUpdate();
			if (status > 0) {
				logger.info("User inserted Successfully");
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
			logger.info("addGoogleUser() Executed");
		}
		return user;
	}

	public ArrayList<UsersVO> getUserDetails(int userId) throws Exception {
		ArrayList<UsersVO> userList = new ArrayList<UsersVO>();
		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet list = stmt
					.executeQuery("select * from register_tbl where user_id='"
							+ userId + "'");
			while (list.next()) {

				UsersVO newUser = new UsersVO(list.getInt("user_id"),
						list.getString("username"),
						list.getString("firstname"),
						list.getString("lastname"), list.getString("email"),
						list.getString("mobile"),
						list.getString("bank_account_no"),
						list.getString("pan_no"), list.getDouble("amount"),
						list.getString("state"), list.getString("country"),
						list.getString("zipcode"), list.getString("role"),
						list.getString("registered_date"));
				userList.add(newUser);

			}
			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getUserDetails() method Executed");
		}
		return userList;
	}

	public ArrayList updateUser(int userId, UsersVO user) {

		String uname = user.getCustomerUserName();
		String fname = user.getCustomerFirstName();
		String lname = user.getCustomerLastName();
		String pwd = user.getCustomerPassword();
		String email = user.getCustomerEmail();
		String mobile = user.getCustomerMobile();
		String account = user.getBankAccountNumber();
		String pan_no = user.getCustomerPan();
		String state = user.getCustomerState();
		String country = user.getCustomerCountry();
		String zipcode = user.getCustomerZipCode();
		String role = user.getRole();
		String date = user.getCreatedDate();
		try {
			int status = 0;
			Connection con = ConnectionHelper.getConnection();
			String updateQuery = "update register_tbl set username=?,firstname=?,lastname=?,password=?,email=?,mobile=?,bank_account_no=?,pan_no=?,state=?,country=?,zipcode=? where user_id="
					+ userId;
			con.setAutoCommit(true);
			PreparedStatement st = con.prepareStatement(updateQuery);
			st.setString(1, uname);
			st.setString(2, fname);
			st.setString(3, lname);
			st.setString(4, pwd);
			st.setString(5, email);
			st.setString(6, mobile);
			st.setString(7, account);
			st.setString(8, pan_no);
			
			st.setString(9, state);
			st.setString(10, country);
			st.setString(11, zipcode);
			System.out.println(updateQuery);

			status = st.executeUpdate();
			if (status > 0) {
				logger.info("Updated Successfully");
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
			logger.info("updateUserMethod() Executed");
		}
		return userList;
	}

	public void deleteUser(int userId) {
		try {
			Connection con = ConnectionHelper.getConnection();
			con.setAutoCommit(true);
			String query = "delete from register_tbl where user_id=" + userId;
			Statement st = con.createStatement();
			st.executeUpdate(query);
			logger.info("User Deleted Successfully");
			st.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("deleteUser() method Executed");
		}
	}

}