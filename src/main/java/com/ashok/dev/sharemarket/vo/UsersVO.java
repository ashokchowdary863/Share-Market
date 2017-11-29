package com.ashok.dev.sharemarket.vo;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsersVO {
	int id;
	String customerUserName;
	String customerFirstName;
	String customerLastName;
	String customerPassword;
	String customerEmail;
	String customerMobile;
	String bankAccountNumber;
	String customerPan;
	double customerAmount;
	String customerState;
	String customerCountry;
	String customerZipCode;
	String role;
	String createdDate;

	public UsersVO() {

	}

	public UsersVO(int id, String customerUserName, String customerFirstName,
			String customerLastName, String customerEmail,
			String customerMobile, String bankAccountNumber,
			String customerPan, double customerAmount, String customerState,
			String customerCountry, String customerZipCode, String role,
			String createdDate) {
		this.id = id;
		this.customerUserName = customerUserName;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.bankAccountNumber = bankAccountNumber;
		this.customerPan = customerPan;
		this.customerAmount = customerAmount;
		this.customerState = customerState;
		this.customerCountry = customerCountry;
		this.customerZipCode = customerZipCode;
		this.createdDate = createdDate;
		this.role = role;
	}

	public UsersVO(int id, String customerUserName, String customerFirstName,
			String customerLastName, String customerPassword,
			String customerEmail, String customerMobile,
			String bankAccountNumber, String customerPan,
			double customerAmount, String customerState,
			String customerCountry, String customerZipCode, String role,
			String createdDate) {
		this.id = id;
		this.customerUserName = customerUserName;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerPassword = customerPassword;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.bankAccountNumber = bankAccountNumber;
		this.customerPan = customerPan;
		this.customerAmount = customerAmount;
		this.customerState = customerState;
		this.customerCountry = customerCountry;
		this.customerZipCode = customerZipCode;
		this.createdDate = createdDate;
		this.role = role;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getCustomerPan() {
		return customerPan;
	}

	public void setCustomerPan(String customerPan) {
		this.customerPan = customerPan;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public String getCustomerZipCode() {
		return customerZipCode;
	}

	public void setCustomerZipCode(String customerZipCode) {
		this.customerZipCode = customerZipCode;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public double getCustomerAmount() {
		return customerAmount;
	}

	public void setCustomerAmount(double customerAmount) {
		this.customerAmount = customerAmount;
	}
}