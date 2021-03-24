package com.example.Phase3Project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int convertInt(String id) {
		try {
		int intId = (int)Integer.parseInt(id);
		return intId;
		} catch(java.lang.NumberFormatException e) {
			return 0;
		}
	}
	
	public User getUser(int id) {
		try {
		return userRepository.findById(id).get();
		} catch (java.util.NoSuchElementException e) {
			return null;
		}
	}
	
	public void editUser(int id, String newUsername, String newPassword) {
		User user = userRepository.findById(id).get();
		user.setUsername(newUsername);
		user.setPassword(newPassword);
		userRepository.save(user);	
	}

}











