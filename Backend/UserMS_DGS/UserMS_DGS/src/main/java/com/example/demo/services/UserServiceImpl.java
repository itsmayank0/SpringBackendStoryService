package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userrepository ;
	

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userrepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}

	@Override
	public boolean validateUser(String mail, String password) {
		
		System.out.println("all users "+userrepository.findAll());
		User user=userrepository.validateUser(mail, password);
		System.out.println("validate user "+user);
		
		if(user!=null)
			return true;
		
		
		return false;
	}
	
	

}
