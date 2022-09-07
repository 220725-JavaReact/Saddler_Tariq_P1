package com.revature.dl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.oh_product_list;
import com.revature.storage.OHProductListList;
import com.revature.util.ConnectionFactory;

public class OHProductListDAO implements DAO<oh_product_list>{

	@Override
	public void addInstance(oh_product_list newInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<oh_product_list> getAllInstances() {
		OHProductListList ohpList = new OHProductListList();
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from oh_product_list";
			Statement stmt = connie.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				ohpList.add(new oh_product_list(rs.getInt("OrderID"), rs.getInt("fk_ProductID"), rs.getInt("fk_CustomerID"), rs.getInt("how_many")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ohpList.getAllElements();
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
	public int findID(oh_product_list newInstance) {
		// TODO Auto-generated method stub
		return 0;
	}

}
