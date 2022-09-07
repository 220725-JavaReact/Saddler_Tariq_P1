package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dl.CustomerDAO;
import com.revature.dl.DAO;
import com.revature.dl.OHProductListDAO;
import com.revature.dl.OrdersDAO;
import com.revature.dl.ProductsDAO;
import com.revature.dl.StoreDAO;
import com.revature.models.customer;
import com.revature.models.oh_product_list;
import com.revature.models.order_history;
import com.revature.models.products;
import com.revature.models.store;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class CheckoutServlet extends HttpServlet {
	private static DAO<customer> customerDao = new CustomerDAO();
	private static DAO<store> storeDao = new StoreDAO();
	private static DAO<products> productsDao = new ProductsDAO();
	private static DAO<order_history> ordersDao = new OrdersDAO();
	public static Logger logger = Logger.getLogger();
	private static DAO<oh_product_list> ohproductsDao = new OHProductListDAO();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		
		logger.log(LogLevel.info, "IN THE CHECKOUT SERVLET");
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		int thisOrderID = 0;
		if(ShopServlet.cart.size() > 0)
		{
			String dateTime = LocalDateTime.now().toString();
			order_history oHistory = new order_history(0, ShopServlet.currentStore, LoginServlet.thisCustomerID, dateTime, ShopServlet.currentPrice);
			ordersDao.addInstance(oHistory);
			//for(order_history thisOrder: ordersDao.getAllInstances())
			thisOrderID = ordersDao.findID(oHistory);
			
			
			
			Collections.sort(ShopServlet.cart);
			int thisID = 0;
			int howMany = 0;
			boolean change = true;
			
			for(int x = 0; x<ShopServlet.cart.size(); x++)
			{
				if(change)
				{
					thisID = ShopServlet.cart.get(x);
					change = false;
				}
				if(ShopServlet.cart.get(x) == thisID)
				{
					howMany++;
				}
				else
				{
					oh_product_list ohList = new oh_product_list(thisOrderID, thisID, LoginServlet.thisCustomerID, howMany);
					ohproductsDao.addInstance(ohList);
					howMany = 1;
					thisID = ShopServlet.cart.get(x);
					change = true;
				}
				if(x == ShopServlet.cart.size()-1 && howMany > 0)
				{
					oh_product_list ohList = new oh_product_list(thisOrderID, thisID, LoginServlet.thisCustomerID, howMany);
					ohproductsDao.addInstance(ohList);
					change = true;
				}
			}
			//logger.log(LogLevel.info, "Items successfuly checked out");
			out.println("<h2>THANK YOU FOR THE PURCHASE!</h2>");
			out.println("<h2>Returning to the menu.</h2>");
			//shopHere(currentID, currentName, storeID, storeName);
			
		}
		else
		{
			//logger.log(LogLevel.warning, "CART EMPTY: NOTHING TO CHECKOUT");
			out.println("<h2>NOTHING IN YOUR CART TO CHECKOUT</h2>");
		}
		
	}
		
}

