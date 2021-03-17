package com.example.Phase3Project1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
	
    @Autowired
    VerifyService service;
    
    Logger logger = LoggerFactory.getLogger(LoginController.class);
   

    @PostMapping(value="/getuser") //@GetMapping for Get servlet variant.
    public String showWelcomePage(ModelMap model, @RequestParam String id){
    	
    	DAO.intId = service.convertInt(id);
    	
    	if(DAO.intId == 0) {
    		model.put("errorMessage", "You did not enter an integer, try again");
    		return "index";
    	}
    	
    	User user= service.getUser(DAO.intId);
    	
    	if(user==null) {
    		model.put("errorMessage", "There is no user associated with id: " + id);
    		return "index";
    	}
    	
    	logger.info("Tentative change for user <" + user.getUsername() + "> with password <" + user.getPassword() + "> and id <" + DAO.intId + ">");
		model.put("username", user.getUsername());
    	model.put("password", user.getPassword());
    	model.put("id", DAO.intId);
        return "edit";
    }
}
