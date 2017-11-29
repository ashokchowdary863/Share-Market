package com.ashok.dev.sharemarket.delegate;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.SharesBO;
import com.ashok.dev.sharemarket.vo.CompaniesVO;
import com.ashok.dev.sharemarket.vo.SharesVO;

public class ShareDelegate {
	SharesBO sharesBO = new SharesBO();
	Logger logger = Logger.getLogger(CompanyDelegate.class);
	
	static {
			
	}

	public ArrayList getAllShares() throws Exception {
		Thread t1=new Thread(new ShareGrowth());
		t1.start();
		return sharesBO.getAllShares();
	}

	public ArrayList getShareDetails(int shareId) throws Exception {
		
		return sharesBO.getShareDetails(shareId);
	}

	public SharesVO addShare(SharesVO newShareData) throws SQLException {
		
		logger.info("addShare() ShareDelegate Executed");
		return sharesBO.addShare(newShareData);
	}

	public void updateShareDetails(int shareId, SharesVO shareData) {
		sharesBO.updateShareDetails(shareId, shareData);
		logger.info("updateShareDetails() ShareDelegate Executed");
	}

	public void deleteShare(int shareId) {
		sharesBO.deleteShare(shareId);
		logger.info("deleteShare() ShareDelegate Executed");
	}

	public class ShareGrowth implements Runnable {

		@Override
		public void run() {
			while (true) {

				
				logger.info("Share Update Thread is running");
				try {
					
					Thread.sleep(300000);
					changeSharePrice();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		public void changeSharePrice() {
			sharesBO.changeSharePrice();
		}

	}
}