package com.wipro.velocity.empowerher.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.velocity.empowerher.model.Trainee;
import com.wipro.velocity.empowerher.repository.TraineeRepository;


@Service
public class TraineeService 
{
	@Autowired
	 private TraineeRepository trepo;
	
	 
	 public String addTrainee(String traineeName,@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate dob, String age, String noOfMembers, String noOfChildren, String maritalStatus,
			 String annualIncome,String email, String contactNumber, String street,String city, String pincode,
			 String adhaarNo, String courseSector,String courseName,String registeredBy,String status, MultipartFile file,String url) throws IOException
	 {
	  Trainee t=new Trainee();
	  
	  t.setTraineeName(traineeName);
	  t.setDob(dob);
	  t.setAge(age);
	  t.setNoOfMembers(noOfMembers);
	  t.setNoOfChildren(noOfChildren);
	  t.setMaritalStatus(maritalStatus);
	  t.setAnnualIncome(annualIncome);
	  t.setEmail(email);
	  t.setContactNumber(contactNumber);
	  t.setStreet(street);
	  t.setCity(city);
	  t.setPincode(pincode);
	  t.setAdhaarNo(adhaarNo);
	  t.setCourseSector(courseSector);
	  t.setCourseName(courseName);
	  t.setRegisteredBy(registeredBy);
	  t.setStatus(status);
	 
	  t.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
	  t.setUrl(url);
	  
	  t=trepo.insert(t);
	  return t.getId();
	 }
	 
	 public Trainee getTraineeById(String id) 
	 { 
	        return trepo.findById(id).get(); 
	 }
	 
	 
	 
	 public Trainee updateTrainee(String id,String traineeName,@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate dob, String age, String noOfMembers, String noOfChildren, String maritalStatus,
			 String annualIncome,String email, String contactNumber, String street,String city, String pincode,
			 String adhaarNo, String courseSector,String courseName, MultipartFile file,String url) throws IOException
	 {
		 
		  Trainee t=trepo.findById(id).get(); 
		 
		  t.setTraineeName(traineeName);
		  t.setDob(dob);
		  t.setAge(age);
		  t.setNoOfMembers(noOfMembers);
		  t.setNoOfChildren(noOfChildren);
		  t.setMaritalStatus(maritalStatus);
		  t.setAnnualIncome(annualIncome);
		  t.setEmail(email);
		  t.setContactNumber(contactNumber);
		  t.setStreet(street);
		  t.setCity(city);
		  t.setPincode(pincode);
		  t.setAdhaarNo(adhaarNo);
		  t.setCourseSector(courseSector);
		  t.setCourseName(courseName);
		 
		  t.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		  t.setUrl(url);
		  
		  t=trepo.save(t);
    	
    	 return t;
	 }
	 
	 public Trainee updateStatus(String id,String status) throws IOException
	 {
		 
		  Trainee t=trepo.findById(id).get(); 
		  
		  t.setStatus(status);
		  
		  t=trepo.save(t);
    	
    	 return t;
	 }
	 
	 public List<Trainee> getTraineeList()
		{
			return trepo.findAll();
		}
	 
	 
	 public Map<String,Boolean> deleteTrainee(String nId) 
	 {
		 Trainee ngo=trepo.findById(nId).get();
	    
		 trepo.delete(ngo);
		 Map<String, Boolean> response=new HashMap<>();
		    response.put("Deleted the Trainee", Boolean.TRUE);
		    return response;
	 }
	 
	 public List<Trainee> getRegisteredBy(String registeredBy)
	 {
		 return (List<Trainee>) trepo.findByRegisteredBy(registeredBy);
	 }
	 
}
