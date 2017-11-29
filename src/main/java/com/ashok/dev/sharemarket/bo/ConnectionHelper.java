package com.ashok.dev.sharemarket.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionHelper {
	static Logger logger=Logger.getLogger(ConnectionHelper.class);
	public static Connection getConnection(){
		try{
		 Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://192.168.35.70:3306/sharebroking_dev", "sharebroking_dev", "sharebroking_dev");
         return con;
		}catch(SQLException e){
			logger.error("SQL Exception:"+e);
		}catch(Exception e){
			logger.error("Exception Occured:"+e);
		}
		return null;
	}
}
