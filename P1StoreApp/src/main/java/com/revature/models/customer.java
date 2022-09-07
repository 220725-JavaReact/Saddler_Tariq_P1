package com.revature.models;

public class customer {
	private int customerID;
	private String fname;
	private String lname;
	private String c_un;
	private String c_pw;
	private String email;
	
	public customer(int customerID, String fname, String lname, String c_un, String c_pw, String email) {
		// TODO Auto-generated constructor stub
		this.customerID = customerID;
		this.fname = fname;
		this.lname = lname;
		this.c_un = c_un;
		this.c_pw = c_pw;
		this.email = email;
	}
	public customer(String fname, String lname, String c_un, String c_pw, String email) {
		// TODO Auto-generated constructor stub
		this.fname = fname;
		this.lname = lname;
		this.c_un = c_un;
		this.c_pw = c_pw;
		this.email = email;
	}
	
	
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		String str = fname.substring(0, 1).toUpperCase() + fname.substring(1);
		this.fname = str;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		String str = lname.substring(0, 1).toUpperCase() + lname.substring(1);
		this.lname = str;
	}
	public String getC_un() {
		return c_un;
	}
	public void setC_un(String c_un) {
		this.c_un = c_un;
	}
	public String getC_pw() {
		return c_pw;
	}
	public void setC_pw(String c_pw) {
		this.c_pw = c_pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
