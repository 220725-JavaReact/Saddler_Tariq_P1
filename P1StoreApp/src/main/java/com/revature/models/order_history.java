package com.revature.models;

public class order_history {
	private int orderID;
	private int storeID;
	private int customerID;
	private String dateTime;
	private double totalCost;
	
	
	public order_history(int orderID, int storeID, int customerID, String dateTime, double totalCost)
	{
		this.orderID = orderID;
		this.storeID = storeID;
		this.customerID = customerID;
		this.dateTime = dateTime;
		this.totalCost = totalCost;
	}
	
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
