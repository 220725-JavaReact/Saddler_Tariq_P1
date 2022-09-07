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

public class RegisterServlet extends HttpServlet{
	
	private static DAO<customer> customerDao = new CustomerDAO();
	public static boolean isValid = false;
	public static Logger logger = Logger.getLogger();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		
		logger.log(LogLevel.info, "IN THE REGISTER SERVLET");
		PrintWriter out = res.getWriter();
		if(isValid)
		{
			String username = req.getParameter("newUsername");
			String email = req.getParameter("newEmail");
			for(customer newCustomer: customerDao.getAllInstances())
			{
				if(username.equals(newCustomer.getC_un()))
				{
					out.println("<h3>THAT USERNAME IS TAKEN</h3>");
					isValid = false;
					break;
				}
				if(email.equals(newCustomer.getEmail()))
				{
					out.println("<h3>THAT EMAIL IS TAKEN</h3>");
					isValid = false;
					break;
				}
			}
			if(isValid)
			{
				customer newCustomer = new customer(req.getParameter("newFirstName"), req.getParameter("newLastName"), username, req.getParameter("newPassword"), email);
				customerDao.addInstance(newCustomer);
				res.sendRedirect("http://localhost:8080/P1StoreApp/Menu");
				
			}
		}
		
		isValid = true;
		
		
		res.setContentType("text/html");
		out.println("<h1> Sign up! </h1>");
		out.println("<h3>Please enter your information below</h3>");
		out.println("<form method = \"get\" action = \"/P1StoreApp/register\">");
		out.println("<p>Username</p>");
		out.println("<br><input type = \"text\" maxlength=14 minlength=1 name = \"newUsername\" required>");
		out.println("<p>Password</p>");
		out.println("<br><input type = \"text\" maxlength=14 minlength=5 name = \"newPassword\" required>");
		
		out.println("<p>First Name</p>");
		out.println("<br><input type = \"text\" maxlength=20 minlength=1 name = \"newFirstName\" required>");
		out.println("<p>Last Name</p>");
		out.println("<br><input type = \"text\" maxlength=20 minlength=1 name = \"newLastName\" required>");
		
		out.println("<p>Email</p>");
		out.println("<br><input type = \"text\" maxlength=30 minlength=1 name = \"newEmail\" required>");
		
		out.println("<input type = \"submit\" value = \"Sign Up!\">");
	
		out.println("</form>");
	}
}
