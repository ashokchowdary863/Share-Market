package com.ashok.dev.sharemarket.bo;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hsqldb.rights.User;

import com.ashok.dev.sharemarket.dao.UserDAO;
import com.ashok.dev.sharemarket.vo.LoginVO;
import com.ashok.dev.sharemarket.vo.UsersVO;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class UsersBO {
	UserDAO doa = new UserDAO();
	Logger logger = Logger.getLogger(UsersBO.class);

	public ArrayList<UsersVO> getAllUsers() throws Exception {
		ArrayList<UsersVO> list = null;
		try {
			UserDAO database = new UserDAO();
			list = database.getAllUsers();
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	public UsersVO addUser(UsersVO user) {
		doa.addUser(user);
		return user;
	}

	public UsersVO addGoogleUser(String tokenId)
			throws GeneralSecurityException, IOException, SQLException {
		try {
			HttpTransport transport = GoogleNetHttpTransport
					.newTrustedTransport();
			JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
			GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
					transport, jsonFactory)
					.setAudience(
							Arrays.asList("542143104500-iu0roqkie8j7f8k0k9mmdlut34abpgoj.apps.googleusercontent.com"))
					.setIssuer("accounts.google.com").build();
			GoogleIdToken idToken = verifier.verify(tokenId);
			logger.info("ID token:" + idToken);
			if (idToken != null) {
				Payload payload = idToken.getPayload();

				// Print user identifier
				String userId = payload.getSubject();
				logger.info("User ID: " + userId);

				// Get profile information from payload
				String email = payload.getEmail();
				boolean emailVerified = Boolean.valueOf(payload
						.getEmailVerified());
				String name = (String) payload.get("name");
				String pictureUrl = (String) payload.get("picture");
				String locale = (String) payload.get("locale");
				String familyName = (String) payload.get("family_name");
				String givenName = (String) payload.get("given_name");

				UsersVO googleUser = new UsersVO();
				googleUser.setCustomerUserName(email.substring(0, 5)
						+ name.substring(0, 3) + familyName.substring(0, 3));
				googleUser.setCustomerEmail(email);
				googleUser.setCustomerPassword("alacriti123");
				googleUser.setCustomerFirstName(givenName);
				googleUser.setCustomerLastName(familyName);
				googleUser.setCustomerMobile("Update Please");
				googleUser.setBankAccountNumber("Update Please");
				googleUser.setCustomerPan("Update Please");
				googleUser.setCustomerAmount(100000);
				googleUser.setCustomerState("Update Please");
				googleUser.setCustomerCountry("Update Please");
				googleUser.setCustomerZipCode("XXXXX");
				googleUser.setRole("customer");
				java.sql.Date date = new java.sql.Date(Calendar.getInstance()
						.getTime().getTime());
				googleUser.setCreatedDate("" + date);
				int emailExistCheck = 0;
				try {
					Connection googleConnection = ConnectionHelper
							.getConnection();
					Statement googleUserNameCheck = googleConnection
							.createStatement();
					ResultSet googleSet = googleUserNameCheck
							.executeQuery("select count(*) from register_tbl where email='"
									+ email + "'");
					if (googleSet.next()) {
						emailExistCheck = googleSet.getInt("count(*)");
					}
					if (emailExistCheck > 0) {
						Statement emailData = googleConnection
								.createStatement();
						ResultSet dataSet = emailData
								.executeQuery("select * from register_tbl where email='"
										+ email + "'");
						if (dataSet.next()) {
							googleUser.setCustomerUserName(dataSet
									.getString("username"));
							googleUser.setCustomerPassword(dataSet
									.getString("password"));
						}
						googleUser.setRole("ee");
						return googleUser;
					}

					googleSet.close();
					googleUserNameCheck.close();
					googleConnection.close();

				} catch (NullPointerException ne) {

				}

				return doa.addGoogleUser(googleUser);
			} else {
				System.out.println("Invalid ID token.");
			}
		} catch (NullPointerException ne) {
			logger.info(ne);

		}
		return null;
	}

	public LoginVO forgotPassword(String emailId) throws SQLException {
		LoginVO mailCheck=new LoginVO();
		final String username = "ashokrj863@gmail.com";
		final String password = "vijaya@amma863";
		String userPassword =null;
		String userUsername=null;
		Connection forgotConnection=ConnectionHelper.getConnection();
		Statement getPassword=forgotConnection.createStatement();
		ResultSet getPasswordData=getPassword.executeQuery("select * from register_tbl where email='"+emailId+"'");
		if(getPasswordData.next()){
			userPassword=getPasswordData.getString("password");
			userUsername=getPasswordData.getString("username");
			mailCheck.setUserName("&%^");
		}else{
			logger.info("Not registered user");
			mailCheck.setUserName("@#$");
			return mailCheck;
		}
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(
					"ashokrj863@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailId));
			message.setSubject("Forgot Password : Share Broking System");
			message.setText("Hi there,\n Your Login Credintionals are \n Username :"+userUsername+"\nPassword:"+userPassword+"\n ***Have a nice day ***");
			Transport.send(message);

			logger.info("Mail Sent Successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return mailCheck;
	}

	public ArrayList<UsersVO> getUserDetails(int userId) throws Exception {
		return doa.getUserDetails(userId);
	}

	public ArrayList updateUser(int userId, UsersVO newUser) {
		ArrayList updateList = doa.updateUser(userId, newUser);
		return updateList;
	}

	public void deleteUser(int userId) {
		doa.deleteUser(userId);
	}
}