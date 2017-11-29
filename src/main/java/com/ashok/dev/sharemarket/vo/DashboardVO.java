package com.ashok.dev.sharemarket.vo;

public class DashboardVO {
	double userAmount;
	int totalShares;
	int boughtShares;
	int soldShares;
	public DashboardVO(){
		
	}
	public DashboardVO(double userAmount,int totalShares,int boughtShares,int soldShares){
		this.userAmount=userAmount;
		this.totalShares=totalShares;
		this.boughtShares=boughtShares;
		this.soldShares=soldShares;
	}
	public double getUserAmount() {
		return userAmount;
	}
	public void setUserAmount(double userAmount) {
		this.userAmount = userAmount;
	}
	public int getTotalShares() {
		return totalShares;
	}
	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}
	public int getBoughtShares() {
		return boughtShares;
	}
	public void setBoughtShares(int boughtShares) {
		this.boughtShares = boughtShares;
	}
	public int getSoldShares() {
		return soldShares;
	}
	public void setSoldShares(int soldShares) {
		this.soldShares = soldShares;
	}
}
