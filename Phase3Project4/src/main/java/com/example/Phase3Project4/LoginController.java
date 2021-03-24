package com.example.Phase3Project4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
	
    @Autowired
    VerifyService service;
    
    @PostMapping(value="/getuser") //@GetMapping for Get servlet variant.
    public String showWelcomePage(ModelMap model, @RequestParam String fname){
    	User user = service.findUser(fname);
    	
    	if(fname == "") {
    		model.put("errorMessage", "You have to enter a username, try again");
    		return "index";
    	}
    	if(user == null) {
    		model.put("errorMessage", "No users exist by that name, try again");
    		return "index";
    	}
    	System.out.println("name is: "+user.getUsername()+"Id is: "+user.getUserId());
    	model.put("fname", user.getFName());
    	model.put("id", user.getUserId());
        return "success";
    }
}
