package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dl.CustomerDAO;
import com.revature.dl.DAO;
import com.revature.dl.ProductsDAO;
import com.revature.dl.StoreDAO;
import com.revature.models.customer;
import com.revature.models.products;
import com.revature.models.store;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class ShopServlet extends HttpServlet{
	private static DAO<customer> customerDao = new CustomerDAO();
	private static DAO<store> storeDao = new StoreDAO();
	private static DAO<products> productsDao = new ProductsDAO();
	public static Logger logger = Logger.getLogger();
	public static List<Integer> cart = new ArrayList<>();
	public static boolean amShopping = false;
	public static String storeName = "";
	public static int currentStore = 0;
	public static double currentPrice = 0.0;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		logger.log(LogLevel.info, "IN THE SHOP SERVLET");
		String amount = req.getParameter("amount");
		PrintWriter out = res.getWriter();
		if(amShopping)
		{
			for(int i = 0; i<Integer.parseInt(amount); i++)
			{
				cart.add(Integer.parseInt(req.getParameter("products")));
			}
		}
		
		res.setContentType("text/html");
		String firstname = "";
		String lastname = "";
		int newInt = LoginServlet.thisCustomerID;
		for(customer thisCustomer: customerDao.getAllInstances())
		{
			if(newInt == thisCustomer.getCustomerID());
			{
				firstname = thisCustomer.getFname();
				lastname = thisCustomer.getLname();
				break;
			}
		}
		if(!amShopping)
		{
			storeName = req.getParameter("stores");
			currentStore = 0;
			for(store thisStore: storeDao.getAllInstances())
			{
				if(storeName.equals(thisStore.getStoreName()))
				{
					currentStore = thisStore.getStoreID();
					break;
				}
				
			}
		}
		
		out.println("<h1>Welcome to " +storeName+", " + firstname + "! </h1>");
		
		for(products thisProduct: productsDao.getAllInstances())
		{
			if(thisProduct.getMyStoreID() == currentStore)
			{
				out.println("<h3>("+ thisProduct.getInventory() +")---"+ thisProduct.getName()+ "------$" +thisProduct.getPrice() + "</h3>");
				out.println("<h4>("+thisProduct.getDetails() + ")</h4>");
			}
		}
		
		out.println("<form method = \"get\" action = \"/P1StoreApp/shop\">");
		out.println("<label for=\"products\">How many?:</label>");
		out.println("<select name=\"products\" id=\"products\">");
		for(products thisProduct: productsDao.getAllInstances())
		{
			if(thisProduct.getMyStoreID() == currentStore)
			{
				//out.println("<h4>("+ thisProduct.getInventory() +")---"+ thisProduct.getName()+ "------$" +thisProduct.getPrice() + "</h4>");
				out.println("<option value=" + thisProduct.getProductID()+" selected>"+ thisProduct.getName() +"</option>");
				
				//out.println("<br><input type = \"text\" maxlength=14 minlength=1 name = \"productID\" value=" + thisProduct.getProductID() + " readonly>");
				
				
				amShopping = true;
				
			}
		}
		out.println("</select>");
		
		out.println("<label for=\"amount\">How many?:</label>");
		out.println("<select name=\"amount\" id=\"amount\">");
		//out.println("<option value=0 selected>0</option>");
		out.println("<option value=1>1</option>");
		out.println("<option value=2>2</option>");
		out.println("<option value=3>3</option>");
		out.println("<option value=4>4</option>");
		out.println("<option value=5>5</option>");
		out.println("</select>");
		out.println("<input type = \"submit\" value = \"Add to cart\">");
		
		out.println("</form>");
		
		out.println("<h3>----------------------------------------</h3>");
		out.println("<h3>Your current cart:</h3>");
		if(cart.size()>0)
		{
			Collections.sort(cart);
			int thisID = 0;
			int howMany = 0;
			int thisProductID = 0;
			//double totalPrice = 0.0;
			boolean change = true;
			
			for(int x = 0; x<cart.size(); x++)//8 9 9
			{
				if(change)
				{
					thisID = cart.get(x);
					change = false;
				}
				if(cart.get(x) == thisID)
				{
					howMany++;
				}
				else
				{
					for(products thisProduct: productsDao.getAllInstances())
					{
						thisProductID = thisProduct.getProductID();
						//System.out.println("PID: " + thisProductID + " = " +ohpList.getProductID() + "?");
						if(thisProductID == thisID)//ohpList.getOrderID() == thisOrderID && product.getProductID() == ohpList.getProductID()
						{
							out.println("<p>(" +howMany + ")---" + thisProduct.getName() + "</p>");
							currentPrice += howMany * thisProduct.getPrice();
							productsDao.decrementInventory(howMany, thisProductID);
							break;
						}
					}
					
					howMany = 1;
					thisID = cart.get(x);
					change = true;
				}
				if(cart.size() == 1 || (x == cart.size()-1 && howMany > 0))//if(cart.size() == 1 || (x == cart.size()-1 && howMany > 0 && change))
					
				{
					
					for(products thisProduct: productsDao.getAllInstances())
					{
						thisProductID = thisProduct.getProductID();
						//System.out.println("PID: " + thisProductID + " = " +ohpList.getProductID() + "?");
						if(thisProductID == thisID)//ohpList.getOrderID() == thisOrderID && product.getProductID() == ohpList.getProductID()
						{
							out.println("<p>(" +howMany + ")---" + thisProduct.getName() + "</p>");
							
							currentPrice += howMany * thisProduct.getPrice();
							productsDao.decrementInventory(howMany, thisProductID);
							break;
							
						}
					}
				}
				
			}
			out.println("<p>Cart size is (" +cart.size() + ")</p>");
			out.println("<p>PRICE: $" +currentPrice + "</p>");
		}
		
		out.println("<form method = \"get\" action = \"/P1StoreApp/checkout\">");
		out.println("<input type = \"submit\" value = \"CHECKOUT\">");
		out.println("</form>");
		
		
	}
}
