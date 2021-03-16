package com.example.Phase3Project1;

import org.springframework.stereotype.Service;

@Service
public class VerifyService {
	
	public boolean isValidUser(String username, String password) {
		if(username.equals("ben")&&password.equals("SimplePassword")) return true;
		else return false;
	}

}
