package com.ashok.dev.sharemarket.delegate;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.UsersBO;
import com.ashok.dev.sharemarket.dao.UserDAO;
import com.ashok.dev.sharemarket.vo.LoginVO;
import com.ashok.dev.sharemarket.vo.UsersVO;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class UserDelegate  {
	Logger logger=Logger.getLogger(UserDelegate.class);
	
	UsersBO userBo=new UsersBO();
	UserDAO doa=new UserDAO();
    public void deleteUser(int userId){
    	userBo.deleteUser(userId);
    }
    
    public UsersVO addGoogleUser(String tokenId) throws GeneralSecurityException, IOException, SQLException{
    	return userBo.addGoogleUser(tokenId);
	}
	
    public LoginVO forgotPassword(String emailId) throws SQLException{
    	return userBo.forgotPassword(emailId);
    }
    
}