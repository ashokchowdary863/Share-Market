package com.ashok.dev.sharemarket.vo;

public class SharesVO {
	int sid;
	int cid;
	String companyName;
	double currentSharePrice;
	double previousSharePrice;
	double increaseDecrease;
	int noOfShares;
	double brokeragePercentage;
	String announcedDate;

	public SharesVO() {

	}

	public SharesVO(int sid, int cid,String companyName,double currentSharePrice,
			double previousSharePrice, double increaseDecrease, int noOfShares,
			 String announcedDate,double brokeragePercentage) {
		this.companyName=companyName;
		this.cid = cid;
		this.sid = sid;
		this.currentSharePrice = currentSharePrice;
		this.previousSharePrice = previousSharePrice;
		this.increaseDecrease = increaseDecrease;
		this.noOfShares = noOfShares;
		this.brokeragePercentage = brokeragePercentage;
		this.announcedDate = announcedDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAnnouncedDate() {
		return announcedDate;
	}

	public void setAnnouncedDate(String announcedDate) {
		this.announcedDate = announcedDate;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public double getCurrentSharePrice() {
		return currentSharePrice;
	}

	public void setCurrentSharePrice(double currentSharePrice) {
		this.currentSharePrice = currentSharePrice;
	}

	public double getPreviousSharePrice() {
		return previousSharePrice;
	}

	public void setPreviousSharePrice(double previousSharePrice) {
		this.previousSharePrice = previousSharePrice;
	}

	public double getIncreaseDecrease() {
		return increaseDecrease;
	}

	public void setIncreaseDecrease(double increaseDecrease) {
		this.increaseDecrease = increaseDecrease;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}

	public double getBrokeragePercentage() {
		return brokeragePercentage;
	}

	public void setBrokeragePercentage(double brokeragePercentage) {
		this.brokeragePercentage = brokeragePercentage;
	}

}
