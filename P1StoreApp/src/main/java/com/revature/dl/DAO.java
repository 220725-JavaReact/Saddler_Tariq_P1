package com.revature.dl;

import java.util.ArrayList;

public interface DAO<T> {
	void addInstance(T newInstance);
	ArrayList<T> getAllInstances();
	void decrementInventory (int howMany, int productID);
	void incrementNumber(int orderID, int productID);
	int findID(T newInstance);
}
