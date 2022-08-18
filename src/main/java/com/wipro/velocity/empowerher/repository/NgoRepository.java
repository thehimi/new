package com.wipro.velocity.empowerher.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.velocity.empowerher.model.Ngo;

public interface NgoRepository extends MongoRepository<Ngo, String> 
{
	public List<Ngo> findByCourseSector(String courseSector);
	public List<Ngo> findByRegisteredBy(String registeredBy);
}
