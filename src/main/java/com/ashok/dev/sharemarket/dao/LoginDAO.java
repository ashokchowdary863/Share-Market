package com.ashok.dev.sharemarket.dao;

import java.sql.*;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.ConnectionHelper;
import com.ashok.dev.sharemarket.vo.LoginVO;

public class LoginDAO {
	Logger logger=Logger.getLogger(LoginDAO.class);
	public LoginVO loginCheck(LoginVO loginDetails) throws SQLException{
		try{
			String userName=loginDetails.getUserName();
			String password=loginDetails.getPassword();
			Connection connection=ConnectionHelper.getConnection();
			Statement statement=connection.createStatement();
			ResultSet loginSet=statement.executeQuery("select * from register_tbl where username='"+userName+"' and password='"+password+"'");
			if(loginSet.next()){
				loginDetails.setRole(loginSet.getString("role"));
				loginDetails.setUserId(loginSet.getInt("user_id"));
			}
			loginSet.close();
			statement.close();
			connection.close();
		}catch(NullPointerException ne){
			logger.error("Null Pointer Exception");
		}catch(Exception e){
			logger.error("Exception Occured");
		}finally{
			logger.info("Login Check method executed");
		}
		
		return loginDetails;
	}
}
