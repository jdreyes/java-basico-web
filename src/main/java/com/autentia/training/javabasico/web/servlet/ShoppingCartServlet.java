package com.autentia.training.javabasico.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7870275320110263337L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Adding new items to user cart
		String name = req.getParameter("name"); //Not used for now
		String price = req.getParameter("price");
		
		HttpSession session = req.getSession();
		session.setAttribute("shoppingCartNItems", (Integer)session.getAttribute("shoppingCartNItems") + 1);
		session.setAttribute("shoppingCartTotalAmount", (Float)session.getAttribute("shoppingCartTotalAmount") + Float.valueOf(price));
		
		resp.sendRedirect(getServletContext().getContextPath() + "/store/catalog");
	}
}
