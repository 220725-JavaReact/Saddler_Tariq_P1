package com.revature.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.products;
import com.revature.storage.ProductList;
import com.revature.util.ConnectionFactory;

public class ProductsDAO implements DAO<products>{

	@Override
	public void addInstance(products newInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<products> getAllInstances() {
		// TODO Auto-generated method stub
		ProductList pList = new ProductList();
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from products";
			Statement stmt = connie.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				pList.add(new products(rs.getInt("ProductID"), rs.getString("p_name"), rs.getString("details"), rs.getDouble("price"), rs.getInt("inventory"), rs.getInt("fk_StoreID")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pList.getAllElements();
	}

	@Override
	public void decrementInventory(int howMany, int productID) {
		// TODO Auto-generated method stub
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			//String query = "Insert into CustomerInfo (c_fname, c_lname, un, pw, email) values (?, ?, ?, ?, ?)";
			String query = "update products set inventory = inventory - ? where ProductID = ?";
			PreparedStatement pstmt = connie.prepareStatement(query);
			pstmt.setInt(1, howMany); 
			pstmt.setInt(2, productID);
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void incrementNumber(int orderID, int productID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int findID(products newInstance) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
