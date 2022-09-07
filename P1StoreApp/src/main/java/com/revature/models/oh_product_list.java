package com.revature.models;

public class oh_product_list {
	
	private int orderID;
	private int productID;
	private int customerID;
	private int howMany;
	
	
	public oh_product_list(int orderID, int productID, int customerID, int howMany)
	{
		this.orderID = orderID;
		this.productID = productID;
		this.customerID = customerID;
		this.howMany = howMany;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int storeID) {
		this.productID = storeID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getHowMany() {
		return howMany;
	}
	public void setHowMany(int howMany) {
		this.howMany = howMany;
	}

}
