package com.wipro.velocity.empowerher.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.velocity.empowerher.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> 
{
	public Admin findByUserName(String username);
}
