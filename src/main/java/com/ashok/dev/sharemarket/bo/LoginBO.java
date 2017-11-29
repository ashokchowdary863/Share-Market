package com.ashok.dev.sharemarket.bo;

import java.sql.SQLException;

import com.ashok.dev.sharemarket.dao.LoginDAO;
import com.ashok.dev.sharemarket.vo.LoginVO;

public class LoginBO {
	LoginDAO loginDAO=new LoginDAO();
	public LoginVO loginCheck(LoginVO loginDetails) throws SQLException{
		
		return loginDAO.loginCheck(loginDetails);
	}
}
