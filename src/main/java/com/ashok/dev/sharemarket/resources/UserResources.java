package com.ashok.dev.sharemarket.resources;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.UsersBO;
import com.ashok.dev.sharemarket.dao.UserDAO;
import com.ashok.dev.sharemarket.delegate.UserDelegate;
import com.ashok.dev.sharemarket.vo.LoginVO;
import com.ashok.dev.sharemarket.vo.UsersVO;
import com.google.gson.Gson;
@Path("/users")
public class UserResources {
	Logger logger=Logger.getLogger(UserResources.class);
	Gson gson=new Gson();
	UserDAO dbres=new UserDAO();
	UsersBO userService=new UsersBO();
	UserDelegate userDelegate=new UserDelegate();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllUsers(){
		String users=null;
		try{
			ArrayList<UsersVO> userList=null;
			userList=userService.getAllUsers();
			Gson gson=new Gson();
			logger.info(gson.toJson(userList));
			users=gson.toJson(userList);
		}catch(Exception e){
			logger.error(e);
		}
		return users;
	}
	@POST
	@Path("/adduser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UsersVO  addUser(UsersVO newUser){
		return  userService.addUser(newUser);
		
	}
	
	
	@POST
	@Path("/addgoogleuser/{tokenId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UsersVO  addGoogleUser(@PathParam("tokenId") String tokenId) throws GeneralSecurityException, IOException, SQLException{
		
		return userDelegate.addGoogleUser(tokenId);
		
	
	}
	
	@GET
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserDetails(@PathParam("userId") int userId) throws Exception{
		String userData=null;
		try{
			ArrayList<UsersVO> userList=userService.getUserDetails(userId);
			
			
			logger.info(gson.toJson(userList));
			userData=gson.toJson(userList);
		}catch(Exception e){
			logger.error(e);
		}
		if(userData.equals(null)){
			return "No User Matched";
		}
		return userData;
	}
	
	@PUT
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateUser(@PathParam("userId") int userId,UsersVO newUser){
	     newUser.setId(userId);
		 userService.updateUser(userId,newUser);
		
		 return gson.toJson(newUser);
		 
	}
	
	@DELETE
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("userId") int userId){
		userDelegate.deleteUser(userId);
	}
	@POST
	@Path("/forgotpassword/{emailId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginVO forgotPassword(@PathParam("emailId") String emailId) throws SQLException{
		return userDelegate.forgotPassword(emailId);
	}
}