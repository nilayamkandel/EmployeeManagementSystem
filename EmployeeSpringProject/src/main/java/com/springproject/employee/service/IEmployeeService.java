package com.springproject.employee.service;

import java.util.List;

import com.springproject.employee.model.Employee;

public interface IEmployeeService {
	
	void addEmployee(Employee e);
	
	void updateEmployee(Employee e);
	
	void deltEmployee(Long id);
	
	Employee getEmployeeById(Long id);
	
	List<Employee> getAllEmployee();
	
	
}
