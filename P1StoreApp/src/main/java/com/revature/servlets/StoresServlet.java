package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dl.CustomerDAO;
import com.revature.dl.DAO;
import com.revature.dl.StoreDAO;
import com.revature.models.customer;
import com.revature.models.store;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class StoresServlet extends HttpServlet{

	private static DAO<customer> customerDao = new CustomerDAO();
	private static DAO<store> storeDao = new StoreDAO();
	public static Logger logger = Logger.getLogger();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		logger.log(LogLevel.info, "IN THE STORES SERVLET");
		String firstname = "";
		String lastname = "";
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.println("<h1>Successfully logged in!<h1>");
		int newInt = LoginServlet.thisCustomerID;
		
		for(customer thisCustomer: customerDao.getAllInstances())
		{
			if(newInt == thisCustomer.getCustomerID());
			{
				//out.println("<h1>CUSTOMER ID IS: " + newInt + "<h1>");
				//out.println("<h1>DOES THAT EQUAL: " + thisCustomer.getCustomerID() + "<h1>");
				firstname = thisCustomer.getFname();
				lastname = thisCustomer.getLname();
				break;
			}
		}
		out.println("<h3>Welcome, " + firstname + " " + lastname + ". Where would you like to shop?");
		
		out.println("<form method = \"get\" action = \"/P1StoreApp/shop\">");
		out.println("<select name=\"stores\" id=\"stores\">");
		
		for(store thisStore: storeDao.getAllInstances())
		{
			
			out.println("<option value=\"" + thisStore.getStoreName() + "\">"+ thisStore.getStoreName() + "</option>");
			out.println("<label for=\"stores\">Choose a store:</label>");
			
			
			
			//out.println("<input type = \"submit\" value = \"" + thisStore.getStoreName() + "\" name = \"Username\">");
		}
		out.println("<input type = \"submit\" value = \"SHOP HERE\">");
		out.println("</select>");
		out.println("</form>");
		
		out.println("<h1>------------------------------------------------------</h1>");
		
		out.println("<form method = \"get\" action = \"/P1StoreApp/orderhistory\">");
		out.println("<input type = \"submit\" value = \"VIEW MY ORDER HISTORY\">");
		out.println("</form>");
		
	}
}
