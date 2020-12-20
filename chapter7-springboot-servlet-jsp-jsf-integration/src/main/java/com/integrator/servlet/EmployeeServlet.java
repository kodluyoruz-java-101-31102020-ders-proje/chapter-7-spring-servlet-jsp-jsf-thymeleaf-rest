package com.integrator.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.integrator.common.service.EmployeeService;

@WebServlet(name = "employeeServlet", urlPatterns = "/employee/servlet", loadOnStartup = 0)
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 3706707075834617854L;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@Override
	public void init() throws ServletException {
		
		System.out.println("Employe Servlet!");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String companyName = req.getParameter("company_name");
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>");
		writer.println(companyName + " şirketi çalışan listesi");
		writer.println("</h1>");
		
		writer.println("<ul>");
		List<String> employees = employeeService.getEmployeeNameList();
		for(String employee : employees) {
			writer.println("<li>" + employee + "</li>");
		}
		writer.println("</ul>");
		
		writer.println("</html>");
	}
	
	@Override
	public void destroy() {
		
		System.out.println("Employee Servlet destroyed!");
	}

}
