package com.revature.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.customer;
import com.revature.models.store;
import com.revature.storage.CustomerList;
import com.revature.storage.StoreList;
import com.revature.util.ConnectionFactory;

public class CustomerDAO implements DAO<customer>{

	@Override
	public void addInstance(customer newInstance) {
		// TODO Auto-generated method stub
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "Insert into CustomerInfo (CustomerID, c_fname, c_lname, un, pw, email) values (DEFAULT, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connie.prepareStatement(query);
			pstmt.setString(1, newInstance.getFname()); 
			pstmt.setString(2, newInstance.getLname());
			pstmt.setString(3, newInstance.getC_un());
			pstmt.setString(4, newInstance.getC_pw());
			pstmt.setString(5, newInstance.getEmail());
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ArrayList<customer> getAllInstances() {
		// TODO Auto-generated method stub
		CustomerList cList = new CustomerList();
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from CustomerInfo";
			Statement stmt = connie.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				cList.add(new customer(rs.getInt("customerid"), rs.getString("c_fname"), rs.getString("c_lname"), rs.getString("un"), rs.getString("pw"), rs.getString("email")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cList.getAllElements();
	}

	@Override
	public void decrementInventory(int howMany, int productID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementNumber(int orderID, int productID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int findID(customer newInstance) {
		// TODO Auto-generated method stub
		return 0;
	}

}
