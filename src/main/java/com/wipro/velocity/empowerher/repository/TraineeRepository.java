package com.wipro.velocity.empowerher.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.velocity.empowerher.model.Trainee;

public interface TraineeRepository extends MongoRepository<Trainee, String> 
{
	public List<Trainee> findByRegisteredBy(String registeredBy);
}
