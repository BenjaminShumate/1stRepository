package com.example.TaskManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManager.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/getuser")
	public String getUser(ModelMap model, @RequestParam String email, @RequestParam String password){
	    	
	    if(email.equals("") || password.equals("")) {
	    	model.put("errorMessage", "You must have a username and a password");
	    	return "login";
	    }
	    	
	    TaskController.user= userService.verifyUser(email, password);
	    	
	   	if(TaskController.user==null) {
	   		model.put("errorMessage", "Invalid credentials");
	   		return "login";
	   	}
	       return "usermenu";
	  }
	
	@GetMapping(value="gousermenu")
	public String goUserMenu(ModelMap model) {
		return "usermenu";
	}
	
	@PostMapping(value="/registeruser")
	public String registerUser(ModelMap model, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
		
		if(name.equals("") || email.equals("") || password.equals("")) {
			model.put("errorMessage", "You must enter a name, email, and password");
			return "register";
		}
		
		if(email.length() < 3 || password.length() < 8) {
			model.put("errorMessage", "Your email cannot be less than three characters and your password must be at least eight characters");
			return "register";
		}
		
		TaskController.user = userService.registerUser(name, email, password);
		
		try {
			if(!TaskController.user.equals(null)) return "login";
		} catch (java.lang.NullPointerException e) {
			model.put("errorMessage", "A user is already linked to that email");
		}
		return "register";
	}
	
	@GetMapping(value="/login")
	public String goLoginView(ModelMap model) {
		return "login";
	}
	
	@GetMapping(value="/register")
	public String goRegisterView(ModelMap model) {
		return "register";
	}
	
	@GetMapping(value="/logout")
	public String logout(ModelMap model) {
		model.put("message", "You have been succesfully logged out");
		return "login";
	}

}
