package com.integrator.jsf.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.integrator.common.service.EmployeeService;
import com.integrator.jsp.controller.model.Employee;

@Component(value = "employeeSaveBean")
@RequestScope
public class EmployeeSaveController {

	@Autowired
	private EmployeeService employeeService;
	
	private Employee newEmployee = new Employee();
	
	
	public void save(Employee emp) {
		
		if(emp != null) {
			
			Employee employee = new Employee();
			employee.setId(emp.getId());
			employee.setName(emp.getName());
			employee.setLastName(emp.getLastName());
			employee.setGender(emp.getGender());
			employee.setHireDate(emp.getHireDate());
			employee.setBirthDate(emp.getBirthDate());
			
			employeeService.save(employee);
			clearNewEmployee();
			
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kullanıcı kayıt işlemi başarılı!", null);
	        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		else {
			
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Kullanıcı kayıt işlemi başarısız!", null);
	        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
	}

	private void clearNewEmployee() {
		
		this.newEmployee.setName("");
		this.newEmployee.setLastName("");
		this.newEmployee.setGender("");
		this.newEmployee.setBirthDate(null);
		this.newEmployee.setHireDate(null);
	}
	
	public Employee getNewEmployee() {
		return newEmployee;
	}

	public void setNewEmployee(Employee newEmployee) {
		this.newEmployee = newEmployee;
	}
}
