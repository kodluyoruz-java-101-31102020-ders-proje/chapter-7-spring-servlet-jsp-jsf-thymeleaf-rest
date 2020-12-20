package com.integrator.common.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrator.jsf.repository.EmployeeRepository;
import com.integrator.jsp.controller.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	@Qualifier("employeeHibernateRepository")
	private EmployeeRepository employeeRepository;
	
	
	public List<com.integrator.jsf.dao.entity.Employee> getAllEmployeeList() {
		
		return employeeRepository.getAllEmployeeList();
	}
	
	public List<String> getEmployeeNameList() {
		
		return Arrays.asList("Ahmet", "Ayşe", "Mehmet", "Fatma");
	}
	
	public List<com.integrator.jsf.dao.entity.Employee> getEmployees() {
		
		return employeeRepository.getAllEmployeeList();
	}
	
	@Transactional
	public Long save(Employee emp) {
		
		Long maxId = employeeRepository.findMaxId();
		
		com.integrator.jsf.dao.entity.Employee employee = new com.integrator.jsf.dao.entity.Employee();
		employee.setEmpNo(maxId);
		employee.setName(emp.getName());
		employee.setLastName(emp.getLastName());
		employee.setGender(emp.getGender());
		employee.setBirthDate(emp.getBirthDate());
		employee.setHireDate(emp.getHireDate());
		
		employee = employeeRepository.save(employee);
		return employee.getEmpNo();
	}
	
	@Transactional
	public Long update(Employee employeeContext) {
		
		com.integrator.jsf.dao.entity.Employee employee = employeeRepository.findWithEmpNo(employeeContext.getId());
		if(employee == null)
		{
			throw new RuntimeException(employeeContext.getId() + " ID not found in DB!");
		}
		
		employee.setName(employeeContext.getName());
		employee.setLastName(employeeContext.getLastName());
		employee.setGender(employeeContext.getGender());
		employee.setBirthDate(employeeContext.getBirthDate());
		employee.setHireDate(employeeContext.getHireDate());
		
		employeeRepository.save(employee);
		return employee.getEmpNo();
	}
	
	@Transactional
	public Long delete(Long empNo) {
		
		employeeRepository.deleteById(empNo);
		return empNo;
	}
	
	public com.integrator.jsf.dao.entity.Employee findById(Long empId) {
		
		return employeeRepository.findWithEmpNo(empId);
	}
}
