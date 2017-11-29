package com.ashok.dev.sharemarket.delegate;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.LoginBO;
import com.ashok.dev.sharemarket.bo.UsersBO;
import com.ashok.dev.sharemarket.vo.LoginVO;

import javax.servlet.http.*;

public class LoginCheckDelegate {
	Logger logger = Logger.getLogger(LoginCheckDelegate.class);
	LoginBO loginBO = new LoginBO();

	LoginVO loginData = null;
	@Context
	HttpServletRequest request;
	

	public LoginVO loginCheck(LoginVO loginDetails) throws SQLException, ServletException, IOException {

		loginData = loginBO.loginCheck(loginDetails);
		if (loginData.getUserId() > 0) {

			logger.info("Logged in");
		}
		
		return loginBO.loginCheck(loginDetails);
	}

}
