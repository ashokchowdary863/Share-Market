package com.ashok.dev.sharemarket.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransactionsVO {
	int transcationId;
	int shareId;
	int userId;
	int noOfShares;
	double growth;
	String action;
	double totalAmount;
	String performedDate;
	String companyName;
	double soldPrice;
	double increaseDecrease;
	String soldDate;
	public TransactionsVO() {

	}

	public TransactionsVO(int transactionId, int shareId, int userId,
			int noOfShares, double growth, String action, double totalAmount,
			String performedDate) {
		this.transcationId=transactionId;
		this.shareId=shareId;
		this.userId=userId;
		this.noOfShares=noOfShares;
		this.growth=growth;
		this.action=action;
		this.totalAmount=totalAmount;
		this.performedDate=performedDate;

	}
	public TransactionsVO(int transactionId, int shareId, int userId,
			int noOfShares, double growth, String action, double totalAmount,
			String performedDate,String companyName,double soldPrice,double increaseDecrease,String soldDate) {
		this.transcationId=transactionId;
		this.shareId=shareId;
		this.userId=userId;
		this.noOfShares=noOfShares;
		this.growth=growth;
		this.action=action;
		this.totalAmount=totalAmount;
		this.performedDate=performedDate;
		this.companyName=companyName;
		this.soldPrice=soldPrice;
		this.increaseDecrease=increaseDecrease;
		this.soldDate=soldDate;
	}

	public int getTranscationId() {
		return transcationId;
	}

	public void setTranscationId(int transcationId) {
		this.transcationId = transcationId;
	}

	public int getShareId() {
		return shareId;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}

	public double getGrowth() {
		return growth;
	}

	public void setGrowth(double growth) {
		this.growth = growth;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPerformedDate() {
		return performedDate;
	}

	public void setPerformedDate(String performedDate) {
		this.performedDate = performedDate;
	}
}
