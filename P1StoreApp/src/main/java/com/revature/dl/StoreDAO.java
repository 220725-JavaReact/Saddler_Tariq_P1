package com.revature.dl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.store;
import com.revature.storage.StoreList;
import com.revature.util.ConnectionFactory;

public class StoreDAO implements DAO<store>{

	@Override
	public void addInstance(store newInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<store> getAllInstances() {
		// TODO Auto-generated method stub
		StoreList sList = new StoreList();
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from stores";
			Statement stmt = connie.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				sList.add(new store(rs.getInt("storeid"), rs.getString("s_name"), rs.getString("s_address")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sList.getAllElements();
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
	public int findID(store newInstance) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
