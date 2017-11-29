package com.ashok.dev.sharemarket.bo;

import java.util.ArrayList;

import com.ashok.dev.sharemarket.dao.WalletDAO;

public class WalletBO {
	WalletDAO walletDAO =new WalletDAO();
	public ArrayList getAllWalletTransactions() throws Exception{
		return walletDAO.getAllWalletTransactions();
	}
	
	public ArrayList getUserWalletTransactions(int userId) throws Exception {
		return walletDAO.getUserWalletTransactions(userId);
	}
}
