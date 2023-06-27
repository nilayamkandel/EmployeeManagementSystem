package com.springproject.employee.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.employee.model.Employee;
import com.springproject.employee.repository.EmployeeRepository;
import com.springproject.employee.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository emplRepo; 

	@Override
	public void addEmployee(Employee e) {
		emplRepo.save(e);
		
	}

	@Override
	public void updateEmployee(Employee e) {
		emplRepo.save(e);
		
	}

	@Override
	public void deltEmployee(Long id) {
		emplRepo.deleteById(id);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return emplRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return emplRepo.findAll();
	}
	
	
}
