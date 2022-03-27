package com.example.demo.services;

import java.util.List;

import com.example.demo.model.User;


public interface UserService {
	
	User saveUser(User user);
	List<User> getAllUser();
	public boolean validateUser(String mail, String password);
	

}
