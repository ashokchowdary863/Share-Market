package com.ashok.dev.sharemarket.bo;

import java.util.ArrayList;

import com.ashok.dev.sharemarket.dao.DashboardDAO;

public class DashboardBO {
	DashboardDAO dashboardDAO=new DashboardDAO();
	public ArrayList getDashboardDetails(int userId){
		return dashboardDAO.getDashboardDetails(userId);
	}
}
