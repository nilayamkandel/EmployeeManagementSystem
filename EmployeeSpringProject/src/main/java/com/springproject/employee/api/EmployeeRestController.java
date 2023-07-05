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
import org.springframework.web.client.RestTemplate;

import com.springproject.employee.model.Employee;
import com.springproject.employee.model.Product;
import com.springproject.employee.repository.ProductRepository;
import com.springproject.employee.service.IEmployeeService;


@RestController
@CrossOrigin
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService empService;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@GetMapping("/api/emp/list")
	public List<Employee> getAll() {
		return empService.getAllEmployee();
	}
	
	
	@GetMapping("/api/emp/{id}")
	public Employee getOneEmp(@PathVariable Long id) {
		return empService.getEmployeeById(id);
	}
	
	@PostMapping("api/emp/add")
	public String add(@RequestBody Employee emp) {
		empService.addEmployee(emp);
		return "success";
	}
	
	@PutMapping("/api/emp/update")
	public String update(@RequestBody Employee emp) {
		empService.updateEmployee(emp);
		return "update success";
	}
	
	@PutMapping("api/emp/delete/{id}")
	public String delete(@PathVariable Long id) {
		empService.deltEmployee(id);
		return "delete success";
	}
	
	//changing json to object j2o
	
	@GetMapping("/api/emp/j2o")
	public String jsonToObjectMapping() {
		RestTemplate temp = new RestTemplate();
		Employee e = temp.getForObject("http://localhost:8080/api/emp/2", Employee.class);
		return "FirstName = "+e.getFname();
	}
	
	//changing json array to object array
	
	@GetMapping("/api/emp/ja2oa")
	public String jarrayToObjectArray() {
		RestTemplate temp = new RestTemplate();
		Employee[] elist = temp.getForObject("http://localhost:8080/api/emp/list", Employee[].class);
		return "FirstName = "+elist[0].getFname();
	}
	
	//storing the api data into database
	@GetMapping("/api/emp/load")
	public String loadProductData() {
		RestTemplate temp = new RestTemplate();
		Product[] plist = temp.getForObject("https://fakestoreapi.com/products", Product[].class);
		prodRepo.saveAll(List.of(plist));
		return "Success";
	}
	

}
