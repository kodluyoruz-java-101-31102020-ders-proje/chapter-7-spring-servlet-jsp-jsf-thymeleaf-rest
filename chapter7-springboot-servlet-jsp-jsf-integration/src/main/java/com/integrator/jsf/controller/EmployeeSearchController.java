package com.integrator.jsf.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.integrator.common.service.EmployeeService;
import com.integrator.jsf.dao.entity.Employee;

@Component(value = "employeeBean")
public class EmployeeSearchController {

	@Autowired
	private EmployeeService employeeService;
	
	
	private Long employeeID = 0L;
	
	private List<Employee> employees;
	
	private List<Employee> gridEmployees;
	
	private Employee selectedEmployee;
	
	
	@PostConstruct
	public void init() {
		
		if(employees == null) {
			employees = employeeService.getEmployees();
			setGridEmployees(employees);
		}
	}
	
	public void search(Long employeeId) {
		
		String message = "Employees not found!";
		Severity severityMessage = FacesMessage.SEVERITY_WARN;
		
		if(employeeId != null && employeeId > 0) {
			
			Employee employee = employeeService.findById(employeeId);
			if(employee != null) {
				setGridEmployees(Arrays.asList(employee));
				message = "Employees found!";
				severityMessage = FacesMessage.SEVERITY_INFO;
			}
		}
		else {
			employees = employeeService.getEmployees();
			setGridEmployees(employees);
			
			if(employees.size() > 0) {
				message = "Employees found!";
				severityMessage = FacesMessage.SEVERITY_INFO;
			}
		}
		
		FacesMessage facesMessage = new FacesMessage(severityMessage, message, null);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
	public void selectEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	
	
	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public List<Employee> getGridEmployees() {
		return gridEmployees;
	}

	public void setGridEmployees(List<Employee> gridEmployees) {
		this.gridEmployees = gridEmployees;
	}
	
}
