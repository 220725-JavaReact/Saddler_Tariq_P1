package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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

public class OrderHistoryServlet extends HttpServlet{
	
	private static DAO<customer> customerDao = new CustomerDAO();
	private static DAO<store> storeDao = new StoreDAO();
	private static DAO<products> productsDao = new ProductsDAO();
	private static DAO<order_history> ordersDao = new OrdersDAO();
	private static DAO<oh_product_list> ohproductsDao = new OHProductListDAO();
	public static Logger logger = Logger.getLogger();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		logger.log(LogLevel.info, "IN THE ORDER HISTORY SERVLET");
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		int thisOrderID = 0;
		int thisProductID = 0;
		for(order_history ohList: ordersDao.getAllInstances())
		{
			if(ohList.getCustomerID() == LoginServlet.thisCustomerID)
			{
				out.println("<h3> You bought ---$" + ohList.getTotalCost() + "--- worth of items</h3>");
				out.println("<h3>On " + ohList.getDateTime()+ "</h3>");
				out.println("<h3>This order was comprised of the following:</h3>");
				thisOrderID = ohList.getOrderID();
			}
			for(oh_product_list ohpList: ohproductsDao.getAllInstances())
			{
				
				for(products thisProduct: productsDao.getAllInstances())
				{
					thisProductID = thisProduct.getProductID();
					//System.out.println("PID: " + thisProductID + " = " +ohpList.getProductID() + "?");
					if(ohpList.getOrderID() == thisOrderID && thisProductID == ohpList.getProductID())//ohpList.getOrderID() == thisOrderID && product.getProductID() == ohpList.getProductID()
					{
						out.println("<h3>" + ohpList.getHowMany() + " units of the " + thisProduct.getName() + "</h3>");
					}
				}
			}
		}
	
	}
}
