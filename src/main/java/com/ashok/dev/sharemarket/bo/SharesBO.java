package com.ashok.dev.sharemarket.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.dao.SharesDAO;
import com.ashok.dev.sharemarket.vo.CompaniesVO;
import com.ashok.dev.sharemarket.vo.SharesVO;

public class SharesBO {
	SharesDAO sharesDAO=new SharesDAO();
	Logger logger=Logger.getLogger(SharesBO.class);
	public ArrayList getAllShares() throws Exception{
		return sharesDAO.getAllShares();
	}
	
	public ArrayList getShareDetails(int shareId) throws Exception{
		return sharesDAO.getShareDetails(shareId);
	}
	
	public SharesVO addShare(SharesVO newShareData) throws SQLException{
		try{
			Connection shareAddConnection=ConnectionHelper.getConnection();
			Statement shareAddStatement=shareAddConnection.createStatement();
			int companyId=0;
			ResultSet shareAddSet=shareAddStatement.executeQuery("select * from companies_tbl where company_name='"+newShareData.getCompanyName()+"'");
			if(shareAddSet.next()){
				companyId=shareAddSet.getInt("company_id");
			}else{
				newShareData.setCompanyName("NE");
				return newShareData;
			}
			newShareData.setCid(companyId);
			newShareData.setPreviousSharePrice(0);
			newShareData.setIncreaseDecrease(0);
			java.sql.Date date = new java.sql.Date(Calendar.getInstance()
					.getTime().getTime());
			newShareData.setAnnouncedDate(""+date);

		}catch(NullPointerException ne){
			logger.error(ne);
		}
		logger.info("addShare() SharesBO Executed");
		return sharesDAO.addShare(newShareData);
	}
	
	public void updateShareDetails(int shareId,SharesVO newShareData){
		sharesDAO.updateShareDetails(shareId,newShareData);
		logger.info("updateShareDetails() SharesBO Executed");
	}
	
	public void deleteShare(int shareId){
		sharesDAO.deleteShare(shareId);
		logger.info("deleteShare() SharesBO Executed");
	}
	public void changeSharePrice(){
		sharesDAO.changeSharePrice();
	}
}
