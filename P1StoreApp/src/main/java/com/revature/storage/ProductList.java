package com.revature.storage;

import java.util.ArrayList;

import com.revature.models.products;

public class ProductList {
	
	private ArrayList<products> backingArray = new ArrayList<products>();

	public ProductList()
	{
		backingArray = new ArrayList<products>();
	}
	
	public void add(products newProduct)
	{
		backingArray.add(newProduct);
	}
	
	public ArrayList<products> getAllElements()
	{
		return backingArray;
	}
}
