package com.springproject.employee.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.employee.model.Employee;
import com.springproject.employee.service.IEmployeeService;


@RestController
@CrossOrigin
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService empService;
	
	@GetMapping("/api/emp/list")
	public List<Employee> getAll() {
		return empService.getAllEmployee();
	}
	
	@PostMapping("api/emp/add")
	public Employee getOneEmp(@PathVariable Long id) {
		return empService.getEmployeeById(id);
	}
	
	public String add(@RequestBody Employee emp) {
		empService.addEmployee(emp);
		return "success";
	}
	
	@PutMapping("/api/emp/update")
	public String update(@RequestBody Employee emp) {
		empService.updateEmployee(emp);
		return "update success";
	}
	
	public String delete(@PathVariable Long id) {
		empService.deltEmployee(id);
		return "delete success";
	}

}
