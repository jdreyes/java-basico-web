package com.autentia.training.javabasico.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		final HttpServletRequest httpReq = (HttpServletRequest)request;
		
		if(httpReq.getSession().getAttribute("user") != null) {
			chain.doFilter(request, response);
			return;
		}

//		Cookie[] cookies = req.getCookies();
//		
//		for(Cookie cookie : cookies) {
//			if(cookie.getName().equalsIgnoreCase("user")) {
//				chain.doFilter(request, response);
//			}
//		}
		
		//Not logged in!
		httpReq.getRequestDispatcher("/logout").forward(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
