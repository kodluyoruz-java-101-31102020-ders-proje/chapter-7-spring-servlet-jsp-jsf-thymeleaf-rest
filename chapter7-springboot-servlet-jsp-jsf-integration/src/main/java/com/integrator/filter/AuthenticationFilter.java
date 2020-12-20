package com.integrator.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName = "authenticationFilter", urlPatterns = "/employee/*")
public class AuthenticationFilter implements Filter {

	private List<String> tokens;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
		tokens = Arrays.asList("ticket1", "ticket2", "ticket3", "ticket4");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletRequest httpReq = (HttpServletRequest)request;
		HttpServletResponse httpRes = (HttpServletResponse)response;
		
		
		String apiKey = httpReq.getHeader("x-api-key");
		if(apiKey == null) {
			
			apiKey = httpReq.getParameter("x-api-key");
			
			if(apiKey == null) {
				httpRes.setContentType("text/plain;chartset=UTF-8");
				httpRes.getWriter().println("You have to set 'x-api-key' to access resources!");
				return;
			}
		}
		else if(!tokens.contains(apiKey)) {
			httpRes.setContentType("text/plain;chartset=UTF-8");
			httpRes.getWriter().println("Your 'x-api-key' is invalid!");
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void destroy() {
		
		tokens.clear();
	}

}
