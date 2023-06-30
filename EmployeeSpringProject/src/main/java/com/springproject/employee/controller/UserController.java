package com.springproject.employee.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.employee.model.User;
import com.springproject.employee.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/login")
	public String getLogin(HttpSession session) {
		if(session.getAttribute("validuser")== null) {
			return "LoginForm";
		}
		
		return "LoginForm";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User  usr = userService.login(user.getUsername(), user.getPassword());
		
		if(usr != null) {
			
			session.setAttribute("validuser",usr);
			session.setMaxInactiveInterval(300);
			//model.addAttribute("user",usr);	
			return "Home";
		}
		model.addAttribute("message","user not found!!");
		return  "LoginForm";	
	}
	
	
	@GetMapping("/signup")
	public String getSignUp() {
		return "SignUpForm";
	}
	
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute User user){
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.signup(user);
		return "LoginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //to kill session after logout
		return "LoginForm";
	}
	
}
