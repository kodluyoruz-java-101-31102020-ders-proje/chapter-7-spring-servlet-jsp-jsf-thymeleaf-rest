package com.integrator.jsf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.integrator.jsf.dao.entity.Employee;

@Repository("employeeHibernateRepository")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query(value = "FROM Employee e WHERE e.empNo = :empNo")
	public Employee findWithEmpNo(@Param("empNo") Long empNo);
	
	@Query(value = "SELECT MAX(e.empNo) FROM Employee e")
	public Long findMaxId();
	
	// SQL sorgusu
	// @Query(value = "SELECT * FROM employees", nativeQuery = true)
	@Query(value = "SELECT e FROM Employee e")
	public List<Employee> getAllEmployeeList();
	
}
