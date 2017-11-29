package com.ashok.dev.sharemarket.delegate;

import java.util.ArrayList;

import com.ashok.dev.sharemarket.bo.WalletBO;
import com.ashok.dev.sharemarket.vo.WalletVO;

public class WalletDelegate {
	WalletBO walletBO=new WalletBO();
	public ArrayList getAllWalletTransactions() throws Exception{
		return walletBO.getAllWalletTransactions();
	}
	
	public ArrayList getUserWalletTransactions(int userId) throws Exception {
		return walletBO.getUserWalletTransactions(userId);
	}
}
