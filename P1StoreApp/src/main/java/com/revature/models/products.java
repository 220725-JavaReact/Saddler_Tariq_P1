package com.revature.models;

public class products {
	private int productID;
	private String name;
	private String details;
	private double price;
	private int inventory;
	private int myStoreID;
	
	public products(int productID, String name, String details, double price, int inventory, int myStoreID)
	{
		this.productID = productID;
		this.name =  name;
		this.details = details;
		this.price = price;
		this.inventory = inventory;
		this.myStoreID = myStoreID;
	}
	
	public products(String name, String details, double price, int inventory, int myStoreID)
	{
		//this.productID = productID;
		this.name =  name;
		this.details = details;
		this.price = price;
		this.inventory = inventory;
		this.myStoreID = myStoreID;
	}
	
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getMyStoreID() {
		return myStoreID;
	}
	public void setMyStoreID(int myStoreID) {
		this.myStoreID = myStoreID;
	}

	
}
