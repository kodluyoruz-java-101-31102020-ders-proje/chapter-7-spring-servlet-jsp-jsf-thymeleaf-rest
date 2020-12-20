package com.integrator.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.integrator.common.service.EmployeeService;
import com.integrator.jsf.dao.entity.Employee;

// call URL from web browser to invoke Controller component!
@Controller
@RequestMapping("/thymeleaf/controller/employee")
public class ThymeLeafEmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getEmployees(Model model) {
		
		// invoke Model
		List<Employee> employees = employeeService.getEmployees();
		model.addAttribute("employees", employees);
		
		// invoke View
		return "pages/thyme_employee_list";
	}
}
