package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class MenuServlet extends HttpServlet{
	//public static boolean loggingIn = false;
	int newInt = 0;
	public static Logger logger = Logger.getLogger();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		logger.log(LogLevel.info, "IN THE MENU SERVLET");
		PrintWriter out = res.getWriter();
		
//		if(loggingIn)
//		{
//			
//		}
		
		if(RegisterServlet.isValid)
		{
			RegisterServlet.isValid = false;
			out.println("<h3>---Registration successful---</h3>");
		}
		
		RegisterServlet.isValid = false;
		//res.getWriter().write("Hello World");
		
		
		res.setContentType("text/html");
        //out.println("<h1></h1>");
        
        out.println("<h3>Log in to begin!</h3>"); 
	
//		ArrayList<Guess> guesses = guessDao.getAllInstances();
//		if(guesses.size() != 0)
//		{
//			tries++;
//			for(Guess thisGuess: guessDao.getAllInstances())
//			{
//				out.println("<br><label>GUESS: " + thisGuess.getGuessName() + " BULLS: " + thisGuess.getBulls() + " COWS: "+ thisGuess.getCows() +"</label>");
//			}
//			//tries++;
//			out.println("<br><label>TRIES: "+ tries+"</label>");
//		}
		

		out.println("<form method = \"get\" action = \"/P1StoreApp/login\">");
		out.println("<p>Username</p>");
		out.println("<br><input type = \"text\" maxlength=14 minlength=1 name = \"Username\">");
		out.println("<p>Password</p>");
		out.println("<br><input type = \"text\" maxlength=14 minlength=1 name = \"Password\">");
		
		out.println("<input type = \"submit\" value = \"LOG IN\">");
	
		out.println("</form>");
		
		
		out.println("<form method = \"get\" action = \"/P1StoreApp/register\">");
		out.println("<h2>----------------------------------------------------</h2>");
		out.println("<input type = \"submit\" value = \"SIGN UP\">");
		out.println("</form>");
		
		
		
		out.println("</body>"); 
		out.println("</html>");
	}

}
