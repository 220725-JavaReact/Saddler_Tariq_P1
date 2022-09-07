package com.revature.storage;

import java.util.ArrayList;

import com.revature.models.order_history;

public class OrderHistoryList {
private ArrayList<order_history> backingArray = new ArrayList<order_history>();
	
	public OrderHistoryList()
	{
		backingArray = new ArrayList<order_history>();
	}
	
	public void add(order_history newOrder)
	{
		backingArray.add(newOrder);
	}
	
	public ArrayList<order_history> getAllElements()
	{
		return backingArray;
	}
}
