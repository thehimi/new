package com.wipro.velocity.empowerher.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.velocity.empowerher.model.User;

public interface UserRepository extends MongoRepository<User, String> 
{
	public User findByEmail(String email);
}
