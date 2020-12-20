package com.integrator.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.integrator.common.service.EmployeeService;
import com.integrator.jsf.dao.entity.Employee;

// We expose Resfful webservices to use from client applications 
// like mobile apps, Javascript client side applications
@RestController("restfullEmployeeService")
@RequestMapping("/rest/webservice/company")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee findByEmpNo(@PathVariable("id") Long id) {
		
		return employeeService.findById(id);
	}
	
	@RequestMapping(value = "/employee/list", method = RequestMethod.GET)
	public List<Employee> getAllEmployeeList() {
		
		return employeeService.getAllEmployeeList();
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Long save(@RequestBody com.integrator.jsp.controller.model.Employee employeeContext) {
		
		return employeeService.save(employeeContext);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public Long update(@RequestBody com.integrator.jsp.controller.model.Employee employeeContext) {
		
		return employeeService.update(employeeContext);
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public Long delete(@PathVariable("id") Long id) {
		
		return employeeService.delete(id);
	}
	
}
