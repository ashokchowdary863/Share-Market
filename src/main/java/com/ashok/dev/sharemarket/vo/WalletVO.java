package com.ashok.dev.sharemarket.vo;

public class WalletVO {
	int walletId;
	int userId;
	String reason;
	double amount;
	String modifiedDate;
	public WalletVO(){
		
	}
	public WalletVO(int walletId,int userId,String reason,double amount,String modifiedDate){
		this.walletId=walletId;
		this.userId=userId;
		this.reason=reason;
		this.amount=amount;
		this.modifiedDate=modifiedDate;
	}
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
