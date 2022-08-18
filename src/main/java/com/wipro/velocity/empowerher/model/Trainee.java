package com.wipro.velocity.empowerher.model;

import java.time.LocalDate;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Document(collection = "trainee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Trainee 
{
	@Id
	private String id;

	// Personal Details
	private String traineeName;

	private @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob;
	private String age;

	// Family Details
	private String noOfMembers;
	private String noOfChildren;
	private String maritalStatus;
	private String annualIncome;

	// Contact Details
	@Indexed(unique = true)
	private String email;

	private String contactNumber;
	private String street;
	private String city;
	private String pincode;

	// Document Section
	@Indexed(unique = true)
	private String adhaarNo;

	// Training Course Details
	private String courseSector;
	private String courseName;
	private String registeredBy;
	private String status;
	public Binary file;
	private String url;
}