package com.autentia.training.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SampleServlet extends GenericServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2008976480458750922L;

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("This is a sample servlet!");
		
		final PrintWriter writer = response.getWriter();
		writer.write("<HTML>");
		writer.write("<HEAD/>");
		writer.write("<BODY>");
		
		writer.write("<P>This is a sample servlet!</P>");
		
		writer.write("</BODY>");
		writer.write("</HTML>");
		writer.close();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
}
