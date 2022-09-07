package com.revature.storage;

import java.util.ArrayList;

import com.revature.models.store;

public class StoreList {
	private ArrayList<store> backingArray = new ArrayList<store>();
	private int lastIndex;
	
	public StoreList() {
		backingArray = new ArrayList<store>();
		lastIndex = 0;
	}
	
	public void add(store newStore)
	{
		// what if the arraylist has reached max cap?
//		if (lastIndex == backingArray.size()) {
//			int newSize = (int) (lastIndex * 1.5);
//			ArrayList<customer> newBacking = new ArrayList<>();
//			System.arraycopy(backingArray, 0, newBacking, 0, backingArray.size());
//			backingArray=newBacking;
//		}
		backingArray.add(newStore);
		lastIndex++;
	}
	public ArrayList<store> getAllElements() {
		return backingArray;
	}

}
