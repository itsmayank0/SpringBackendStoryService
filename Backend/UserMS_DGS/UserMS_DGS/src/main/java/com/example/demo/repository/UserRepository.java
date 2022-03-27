package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	@Query("{'mail':{$in : [?0] },'password':{$in : [?1] }}")
	public User validateUser(String mail, String password);
}
