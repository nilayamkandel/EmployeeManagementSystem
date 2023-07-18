package com.springproject.employee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.employee.model.Employee;
import com.springproject.employee.service.IDepartmentService;
import com.springproject.employee.service.IEmployeeService;
import com.springproject.employee.utils.EmployeeExcelView;
import com.springproject.employee.utils.EmployeePdfView;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService emplService;
	
	@Autowired
	private IDepartmentService deptService;

	@GetMapping("/add")
	public String getEmployee(HttpSession session, Model model) {
		if(session.getAttribute("validuser")== null) {
			return "LoginForm";
		}
		model.addAttribute("deptList",deptService.getAllDepts());
		return "EmployeeAddForm";
	}
	
	@PostMapping("/add")
	public String postEmployee(@ModelAttribute Employee emp) {
		emplService.addEmployee(emp);
		return "redirect:/employee/add";
	}
	
	//inside department list we contain edit, delete and view. inside edit there is update option
	@GetMapping("/list")
	public String getEmployeeList(HttpSession session, Model model) {
		if(session.getAttribute("validuser")== null) {
			return "LoginForm";
		}
		model.addAttribute("emplList", emplService.getAllEmployee());
		return "EmployeeListForm";
	}
	
	@GetMapping("/edit")
	public String editEmployee(@RequestParam long id, HttpSession session, Model model) {
		if(session.getAttribute("validuser")== null) {
			return "LoginForm";
		}
		model.addAttribute("empObject",emplService.getEmployeeById(id));
		model.addAttribute("deptList",deptService.getAllDepts());
		return "EmployeeEditForm";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee emp) {
		emplService.updateEmployee(emp);
		return "redirect:/employee/list";
	}
	
	@GetMapping("/delete")
	public String deltEmployee(@RequestParam long id) {
		emplService.deltEmployee(id);
		return "redirect:/employee/list";
	}
	
	@GetMapping("/view")
	public String viewEmployee(@RequestParam long id,Model model) {
		model.addAttribute("deptList",deptService.getAllDepts());
		model.addAttribute("empObject",emplService.getEmployeeById(id));
		return "EmployeeViewForm";
	}
	
	@GetMapping("/excel")
	public ModelAndView excelView() {
		ModelAndView mv = new ModelAndView();
		mv.setView(new EmployeeExcelView());
		mv.addObject("list", emplService.getAllEmployee());
		return mv;
	}
	
	@GetMapping("/pdf")
	public ModelAndView pdfView() {
		ModelAndView mv = new ModelAndView();
		mv.setView(new EmployeePdfView());
		mv.addObject("list", emplService.getAllEmployee());
		return mv;
	}
	
}
