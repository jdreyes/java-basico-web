package com.autentia.training.javabasico.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static final String USER = "admin";
	private static final String PASSWORD = "admin";
	
	private static final int MAX_EXPIRATION_SECONDS = 30;
	
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
			HttpSession session = req.getSession(true);
			
			//If a current session exists
			if(!session.isNew()) {
				//Create a new, fresh session
				session.invalidate();
				session = req.getSession(true);
			}
			
			session.setMaxInactiveInterval(MAX_EXPIRATION_SECONDS);//seconds
			session.setAttribute("user", user);
			
			final Cookie cookie = new Cookie("user", user);
			cookie.setMaxAge(MAX_EXPIRATION_SECONDS);
			resp.addCookie(cookie);
			
			resp.sendRedirect("store/catalog");

		} else {
//			final RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
//			final PrintWriter writer = resp.getWriter();
//			writer.println("<font color=red>Wrong user / password. Please try again</font>");
//			rd.include(req, resp);
//			
//			writer.close();
			
			final RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			req.setAttribute("loginError", "User / password were incorrect. Please try again!");
			rd.forward(req, resp);
		}
	}
}
