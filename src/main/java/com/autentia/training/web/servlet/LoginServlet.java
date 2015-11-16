package com.autentia.training.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static final String USER = "admin";
	private static final String PASSWORD = "admin";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7944617463099926335L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		
		if(user.equalsIgnoreCase(USER) && password.equalsIgnoreCase(PASSWORD)) {
			
			//Session
			final HttpSession session = req.getSession(true);
			
			session.setMaxInactiveInterval(30);//seconds
			
			final PrintWriter writer = resp.getWriter();
			
			writer.println("<P>Welcome, ");
			writer.println(user.trim());
			writer.println("</P>");
			writer.println("<P>");
			writer.println("Your session ID is: ");
			writer.println(session.getId());
			writer.println("</P>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/store/catalog.html");
			rd.include(req, resp);
			
			writer.close();
		} else {
			final RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			final PrintWriter writer = resp.getWriter();
			writer.println("<font color=red>Wrong user / password. Please try again</font>");
			rd.include(req, resp);
			
			writer.close();
		}
	}
}
