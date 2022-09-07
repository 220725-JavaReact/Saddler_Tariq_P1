package com.revature.storage;

import java.util.ArrayList;

import com.revature.models.customer;


public class CustomerList {
	private ArrayList<customer> backingArray = new ArrayList<customer>();

	public CustomerList()
	{
		backingArray = new ArrayList<customer>();
	}
	
	public void add(customer newCustomer)
	{
		backingArray.add(newCustomer);
	}
	
	public ArrayList<customer> getAllElements()
	{
		return backingArray;
	}
}
