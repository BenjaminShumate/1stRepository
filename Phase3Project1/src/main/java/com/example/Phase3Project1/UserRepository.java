package com.example.Phase3Project1;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

   // public User findByName(String name);
}