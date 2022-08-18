package com.wipro.velocity.empowerher.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.velocity.empowerher.model.Trainee;
import com.wipro.velocity.empowerher.service.TraineeService;



@RestController
@CrossOrigin(origins="https://women-emp-359811.el.r.appspot.com")
@RequestMapping("/api")
public class TraineeController 
{
	@Autowired
	 private TraineeService ts;
	
	//POST- // http://localhost:9095/wep/api/registerTrainee
	 @PostMapping("/registerTrainee")
	 public String addDoc(@RequestParam("traineeName") String traineeName,@RequestParam("dob") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate dob,
			 @RequestParam("age") String age, @RequestParam("noOfMembers") String noOfMembers,
			 @RequestParam("noOfChildren") String noOfChildren, @RequestParam("maritalStatus") String maritalStatus,
			 @RequestParam("annualIncome") String annualIncome,@RequestParam("email") String email,
			 @RequestParam("contactNumber") String contactNumber, @RequestParam("street") String street,
			 @RequestParam("city") String city, @RequestParam("pincode") String pincode,
			 @RequestParam("adhaarNo") String adhaarNo, @RequestParam("courseSector") String courseSector,
			 @RequestParam("courseName") String courseName, @RequestParam("registeredBy") String registeredBy,
			 @RequestParam("status") String status, @RequestParam("file") MultipartFile file,
			 @RequestParam("url") String url) throws IOException  
	 {
	 String id= ts.addTrainee(traineeName, dob, age,noOfMembers,noOfChildren,maritalStatus,annualIncome,email,
			  contactNumber,street,city,pincode,adhaarNo,courseSector,courseName,registeredBy,status,file,url);
	  
	  return id;
	 }	
	 
	//GET-  http://localhost:9095/wep/api/findAllTrainees
	 @GetMapping("/findAllTrainees")
	 public List<Trainee> getTraineeList()
		{
			return ts.getTraineeList();
		}
	 
	  // GET - http://localhost:9095/wep/api/trainee/101
	 @GetMapping("/trainee/{id}")
	 public ResponseEntity<Trainee> getTraineeById(@PathVariable String id) 
	 {
	     Trainee trainee = ts.getTraineeById(id);
	     return ResponseEntity.ok().body(trainee);
	 }
	 
	
	// PUT - http://localhost:9095/wep/api/trainees/101
	 @PutMapping("/trainees/{id}")
	    public ResponseEntity<Trainee> updateTrainee(@PathVariable(value="id") String nId,
	    		@Validated @RequestParam("traineeName") String traineeName,@RequestParam("dob") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate dob,
				 @RequestParam("age") String age, @RequestParam("noOfMembers") String noOfMembers,
				 @RequestParam("noOfChildren") String noOfChildren, @RequestParam("maritalStatus") String maritalStatus,
				 @RequestParam("annualIncome") String annualIncome,@RequestParam("email") String email,
				 @RequestParam("contactNumber") String contactNumber, @RequestParam("street") String street,
				 @RequestParam("city") String city, @RequestParam("pincode") String pincode,
				 @RequestParam("adhaarNo") String adhaarNo, @RequestParam("courseSector") String courseSector,
				 @RequestParam("courseName") String courseName, @RequestParam("file") MultipartFile file,
				 @RequestParam("url") String url) throws IOException  
	    {

		 Trainee trainee=ts.updateTrainee(nId,traineeName, dob, age,noOfMembers,noOfChildren,maritalStatus,annualIncome,email,
				 contactNumber,street,city,pincode,adhaarNo,courseSector,courseName,file,url);
	    	 return ResponseEntity.ok().body(trainee);
	    }
	 
	 @PutMapping("/trainee/{id}")
	    public ResponseEntity<Trainee> updateStatus(@PathVariable(value="id") String nId,
	    		@Validated @RequestParam("status") String status) throws Exception
	    {
		 Trainee trainee=ts.updateStatus(nId,status);
		 
	    	 return ResponseEntity.ok().body(trainee);
	    }
	  
	 
	// DELETE - http://localhost:9095/wep/api/trainees	/101
	    @DeleteMapping("trainees/{id}")
	    public Map<String,Boolean> deleteTrainee(@PathVariable(value="id") String nId)
	     {
		    return ts.deleteTrainee(nId);
	     }
	    
	    @GetMapping("/gettraineebyregisteredby/{registeredBy}")
	  	public List<Trainee> getTraineeByRegisteredBy(@PathVariable(value="registeredBy") String registeredBy)
	  	{
	  		//invokes findBySector() custom method of MongoRepository
	  		return ts.getRegisteredBy(registeredBy);  //invokes findAll() method of MongoRepository
	  		
	  	}
}