package com.ashok.dev.sharemarket.delegate;

import java.util.ArrayList;

import com.ashok.dev.sharemarket.bo.DashboardBO;

public class DashboardDelegate {
	DashboardBO dashboardBO=new DashboardBO();
	public ArrayList getDashboardDetails(int userId){
		return dashboardBO.getDashboardDetails(userId);
	}
}
