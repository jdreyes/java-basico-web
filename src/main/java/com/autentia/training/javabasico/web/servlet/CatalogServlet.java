package com.autentia.training.javabasico.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.autentia.training.javabasico.core.bean.Catalog;
import com.autentia.training.javabasico.core.bean.Product;

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
			session.setAttribute("shoppingCartTotalAmount", 0.0F);
		}
		
		
		List<Product> productList = new ArrayList<Product>();
		
		try {
			productList = createCatalog(req);
		
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	
//		
//		final List<Product> productList = new ArrayList<Product>();
//		
//		productList.add(Product.valueOf("Videogame", "Bug!-the videogame for Autentia Box 360", new BigDecimal(39.95F)));
//		productList.add(Product.valueOf("Autentia Box 360", "Best console in the world", new BigDecimal(330)));
		
		req.setAttribute("productList", productList);
		
		//redirect
		req.getServletContext().log("Catalog loaded");
		req.setAttribute("author", req.getServletContext().getAttribute("author"));
		req.setAttribute("applicationName", req.getServletContext().getServletContextName());
		req.setAttribute("applicationVersion", req.getServletContext().getInitParameter("applicationVersion"));
		req.getRequestDispatcher("/store/catalog.jsp").forward(req, resp);
		
		
	}

	private List<Product> createCatalog(HttpServletRequest req) throws JAXBException {
		
		InputStream catalogIs = req.getServletContext().getResourceAsStream((String)req.getServletContext().getInitParameter("catalog"));
	
		JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class, Product.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		final Catalog catalog = (Catalog)unmarshaller.unmarshal(catalogIs);
		
		return catalog.getProductList();
	}
}
