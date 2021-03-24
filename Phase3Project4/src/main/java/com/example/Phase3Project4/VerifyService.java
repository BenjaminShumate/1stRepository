package com.example.Phase3Project4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findUser(String fname) {
		try {
			 Iterable<User> users = userRepository.findAll();
			 for(User user: users) {
				 if(user.getFName().equals(fname)) return user;
			 }
			return null;
		} catch (java.util.NoSuchElementException e) {
			return null;
		}
	}
}











