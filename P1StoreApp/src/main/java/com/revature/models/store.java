package com.revature.models;

public class store {
	private int storeID;
	private String storeName;
	private  String storeAddress;
	
	public store(int storeID, String storeName, String storeAddress)
	{
		this.storeID = storeID;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
	}
	
	
	
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	
	
	

}
