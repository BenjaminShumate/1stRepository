package com.example.Phase3Project1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditController {

    @Autowired
    VerifyService service;

    Logger logger = LoggerFactory.getLogger(EditController.class);
    
    @PostMapping(value="/modify")
    public String modifyUser(ModelMap model, @RequestParam String newUsername, @RequestParam String newPassword){
    
    	if(newUsername.equals("") || newPassword.equals("")) {
    		model.put("errorMessage", "You have to have a username and a password");
    		return "edit";
    	}
    	
    	if(newUsername.length() < 8 || newPassword.length() < 8) {
    		model.put("errorMessage", "Your username and password need to be at least 8 characters long");
    		return "edit";
    	}
    	
    	service.editUser(DAO.intId, newUsername, newPassword);
    	logger.info("Confirmed change for user <" + newUsername + "> with password <" + newPassword + "> and id <" + DAO.intId + ">");
    	model.put("newUsername", newUsername);
    	model.put("newPassword", newPassword);
   		return "success";
    }
}