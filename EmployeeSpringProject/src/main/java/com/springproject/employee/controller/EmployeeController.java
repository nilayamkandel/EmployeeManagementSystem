package com.springproject.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.employee.model.Employee;
import com.springproject.employee.service.IEmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService emplService;
	
	@GetMapping("/add")
	public String getEmployee() {
		return "EmployeeForm";
	}
	
	@PostMapping("/add")
	public String postEmpmloyee(@ModelAttribute Employee emp) {
		emplService.addEmployee(emp);
		return "EmployeeForm";
	}
	
	
}
