package com.autentia.training.javabasico.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CatalogServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7944617463099926335L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		final PrintWriter writer = resp.getWriter();
		
//		String user = "";
//		
//		Cookie[] cookies = req.getCookies();
//		
//		for(Cookie cookie : cookies) {
//			if(cookie.getName().equalsIgnoreCase("user")) {
//				user = cookie.getValue();
//			}
//		}
//		
//		writer.println("<P>Welcome, ");
//		writer.println(user.trim());
//		writer.println("</P>");
//		writer.println("<P>");
//		writer.println("Your session ID is: ");
//		writer.println(req.getSession().getId());
//		writer.println("</P>");
		
// 		req.getRequestDispatcher("/store/catalog.jsp").include(req, resp);
		
//		writer.close();
		
		
		//Shopping cart should be calculated dinamically. 
		//Here we put its information directly
		final HttpSession session = req.getSession();
		
		if(session.getAttribute("shoppingCartNItems") == null) {
			session.setAttribute("shoppingCartNItems", 0);
			session.setAttribute("shoppingCartTotalAmount", 0.0);
		}
		
		//redirect
		req.getRequestDispatcher("/store/catalog.jsp").forward(req, resp);
		
		
	}
}
