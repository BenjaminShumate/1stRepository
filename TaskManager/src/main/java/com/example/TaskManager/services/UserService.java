package com.example.TaskManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.User;
import com.example.TaskManager.exception.UserNotFound;
import com.example.TaskManager.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User verifyUser(String email, String password) {
		Iterable<User> users= userRepository.findAll();
		for(User u : users) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				 return u;
			}
		}
		throw new UserNotFound();
	}
	
	public User registerUser(String name, String email, String password) {
		User user = new User(name, email, password);
		try {
			userRepository.save(user);
			return user;
		} catch(org.springframework.dao.DataIntegrityViolationException e) {
			return null;
		}
	}
}
