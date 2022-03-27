package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.User;
import com.example.demo.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {
	
	private Map<String, String> map=new HashMap<>();
	
	@Autowired
	private UserService userservice;
	
	private ResponseEntity responseEntity;
	
	@GetMapping("/check")
	public String checkUserController()
	{
		return "user controller";
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<?> getUser()
	{
		return new ResponseEntity<> (userservice.getAllUser(),HttpStatus.OK);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		try
		{
			System.out.println("register "+user.toString());
			responseEntity = new ResponseEntity<>(userservice.saveUser(user),HttpStatus.CREATED);
			//System.out.println("no exceptio in SAVE USER");
		}
		catch(Exception eobj)
		{
			System.out.println("exceptio in SAVE USER"+eobj);
			responseEntity = new ResponseEntity<>("Unable to post .i.e., Duplicate found ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user)
	{
		System.out.println("login "+user);
		try
		{
			System.out.println(" given user details: "+ user);
			String jwtToken=generateToken(user.getMail(),user.getPassword());
			
			
			
			map.put("message", "User Successfully Logged In");
			map.put("token", jwtToken);
		}
		catch(Exception e)
		{
			map.put("message", e.getMessage());
			map.put("expception token",null);
			return new ResponseEntity<>("no valid credentials",HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	private String generateToken(String mail,String password) throws Exception
	{
		
		String jwtToken="";
		System.out.println("in gen token: "+mail+' '+password);
		if(mail==null || password==null)
		{
			System.out.println("in if exception");
			//throw new ServletException("Please send valid username and password");
		}
		
		boolean flag = userservice.validateUser(mail, password);
		
		System.out.println("validate user boolean: "+flag);
		
		if(!flag)
		{
			throw new Exception("jwt filter exception");
			//throw new ServletException("Invalid Credentials");
		}
		else
		{
			System.out.println("before else");
			jwtToken=Jwts.builder()
			        .setSubject(mail)
			        .setIssuedAt(new Date())
			        .setExpiration(new Date(System.currentTimeMillis() + 30000000))
			        .signWith(SignatureAlgorithm.HS256, "secret key")
			        .compact();
					
			System.out.println("after else");
		}
		
		return jwtToken;
	}

}
