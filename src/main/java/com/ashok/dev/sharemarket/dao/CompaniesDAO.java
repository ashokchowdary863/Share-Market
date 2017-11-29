package com.ashok.dev.sharemarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.ashok.dev.sharemarket.bo.CompaniesBO;
import com.ashok.dev.sharemarket.bo.ConnectionHelper;
import com.ashok.dev.sharemarket.vo.CompaniesVO;

public class CompaniesDAO {
	Logger logger = Logger.getLogger(CompaniesDAO.class);


	public ArrayList<CompaniesVO> getAllCompanies() throws Exception {
		ArrayList<CompaniesVO> companiesList = new ArrayList<CompaniesVO>();
		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet list = stmt.executeQuery("select * from companies_tbl");
			while (list.next()) {

				CompaniesVO company = new CompaniesVO(list.getInt("company_id"),
						list.getString("company_name"),
						list.getString("company_owner"),
						list.getString("company_description"),
						list.getDouble("growth"),
						list.getString("registered_date"));
						
				companiesList.add(company);

			}
			list.close();
			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getAllComapnies() Executed");
		}
		return companiesList;
	}
	public ArrayList<CompaniesVO> getCompanyDetails(int companyId) throws Exception {
		ArrayList<CompaniesVO> companiesList = new ArrayList<CompaniesVO>();
		try {

			Connection con = ConnectionHelper.getConnection();
			Statement stmt = con.createStatement();
			ResultSet list = stmt.executeQuery("select * from companies_tbl where company_id='"+companyId+"'");
			while (list.next()) {

				CompaniesVO company = new CompaniesVO(list.getInt("company_id"),
						list.getString("company_name"),
						list.getString("company_owner"),
						list.getString("company_description"),
						list.getDouble("growth"),
						list.getString("registered_date"));
						
				companiesList.add(company);

			}
			list.close();
			stmt.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("getAllComapnies() Executed");
		}
		return companiesList;
	}
	public CompaniesVO addCompany(CompaniesVO newCompanyData){
		try {
			String company_name=newCompanyData.getCompanyName();
			String company_owner=newCompanyData.getCompanyOwner();
			String company_desc=newCompanyData.getCompanyDescription();
			double growth=newCompanyData.getGrowth();
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

			int status = 0;
			Connection con = ConnectionHelper.getConnection();
			String query = "insert into companies_tbl" + " VALUES"
					+ "(null,?,?,?,?,?)";
			con.setAutoCommit(true);
			PreparedStatement st = con.prepareStatement(query);
			logger.info(company_name+":"+company_owner+":"+company_desc+":"+growth+":"+date);
			st.setString(1, company_name);
			st.setString(2, company_owner);
			st.setString(3, company_desc);
			st.setDouble(4, growth);
			st.setDate(5,date);
			status = st.executeUpdate();
			if (status > 0) {
				logger.info("Company Registered Successfully...");
			} else
				logger.info("Error Occured");
			st.close();
			con.close();
			return newCompanyData;
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("addCompany() CompanyDAO Executed");
		}
		return null;
	}
	
	public void updateCompanyDetails(int companyId,CompaniesVO companyData){

		String company_name = companyData.getCompanyName();
		String company_owner = companyData.getCompanyOwner();
		String company_desc = companyData.getCompanyDescription();
		double growth = companyData.getGrowth();
		
		try {
			int status = 0;
			Connection con = ConnectionHelper.getConnection();
			String updateQuery = "update companies_tbl set company_name=?,company_owner=?,company_description=?,growth=? where company_id="
					+ companyId;
			con.setAutoCommit(true);
			PreparedStatement st = con.prepareStatement(updateQuery);
			st.setString(1, company_name);
			st.setString(2, company_owner);
			st.setString(3, company_desc);
			st.setDouble(4, growth);
			
			logger.info(updateQuery);

			status = st.executeUpdate();
			if (status > 0) {
				logger.info("Company information Updated successfully");
			} else
				logger.info("Error Occured");
			st.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("updateCompanyDetails() CompanyDAO Executed");
		}
		
	}
	
	public void deleteCompany(int companyId){
		try {
			Connection con = ConnectionHelper.getConnection();
			con.setAutoCommit(true);
			String query = "delete from companies_tbl where company_id=" + companyId;
			Statement st = con.createStatement();
			st.executeUpdate(query);
			logger.info("Company Deleted Successfully");
			st.close();
			con.close();
		} catch (NullPointerException ne) {
			logger.error("Null Pointer Exception :" + ne);
		} catch (SQLException se) {
			logger.error("SQL Exception :" + se);
		} catch (Exception e) {
			logger.error("Exception :" + e);
		} finally {
			logger.info("deleteCompany() CompanyDAO method Executed");
		}
	}
}
