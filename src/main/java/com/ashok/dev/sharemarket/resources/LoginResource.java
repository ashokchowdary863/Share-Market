package com.ashok.dev.sharemarket.resources;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.delegate.LoginCheckDelegate;
import com.ashok.dev.sharemarket.vo.LoginVO;

@Path("/login")
public class LoginResource {
	@Context
	private HttpServletRequest request;
	Logger logger=Logger.getLogger(LoginResource.class);
	LoginCheckDelegate loginDelegate=new LoginCheckDelegate();
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginVO loginCheck(LoginVO loginDetails) throws SQLException, ServletException, IOException{
		HttpSession session=request.getSession();
		logger.info(session.getId());
		return loginDelegate.loginCheck(loginDetails);
	}
	
	
}
