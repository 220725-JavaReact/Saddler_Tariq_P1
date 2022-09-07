package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dl.CustomerDAO;
import com.revature.dl.DAO;
import com.revature.models.customer;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class LoginServlet extends HttpServlet{
	public static int thisCustomerID = 0;
	private static DAO<customer> customerDao = new CustomerDAO();
	public static Logger logger = Logger.getLogger();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		logger.log(LogLevel.info, "IN THE LOGIN SERVLET");
		boolean flag = false;
		String un = req.getParameter("Username");
		String pw = req.getParameter("Password");
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		out.println("<h1>Logging you in, please wait...</h1>");
		
		for(customer thisCustomer: customerDao.getAllInstances())
		{
			if(thisCustomer.getC_un().equals(un) && thisCustomer.getC_pw().equals(pw))
			{
				flag = true;
				thisCustomerID = thisCustomer.getCustomerID();
				res.sendRedirect("http://localhost:8080/P1StoreApp/stores");
				break;
			}
		}
		if(!flag)
		{
			res.sendRedirect("http://localhost:8080/P1StoreApp/Menu");
		}
	}

}
