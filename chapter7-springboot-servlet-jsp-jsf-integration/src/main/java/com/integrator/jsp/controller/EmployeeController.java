package com.integrator.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.integrator.common.service.EmployeeService;
import com.integrator.jsf.dao.entity.Employee;

// Controller module in MVC Pattern
@Controller
@RequestMapping("/jsp/controller/employee")
public class EmployeeController {

	// Model Dependency
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getEmployees(Model model) {
		
		// Model
		List<Employee> employees = employeeService.getEmployees();
		
		model.addAttribute("viewEmployees", employees);
		model.addAttribute("message", "Merhaba ben backend'den geliyorum");
		
		// View
		return "pages/jsp/employee_list";
	}
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greeting(Model model) {
		
		model.addAttribute("greetingMessage", "Merhaba JSP Dünyası!");
		
		return "pages/jsp/greeting";
	}
	
}
