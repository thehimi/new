package com.wipro.velocity.empowerher.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="ngo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ngo 
{
	@Id
	private String id;
	private Binary mult;

	private String ngoName;
	private String ngoState;
	private String ngoDistrict;
	private String ngoType;

	@Indexed(unique=true)
	private String ngoUniqueId;

	@Indexed(unique=true)
	private String ngoEmail;

	@Indexed(unique=true)
	private String ngoWebsiteLink;

	//Course Details
	private String courseName;
	private String courseSector;
	private String courseDuration;
	private String courseMode;
	private String maxPeople;

	//Incharge Details
	private String inChargeName;

	@Indexed(unique=true)
	private String inChargeEmailId;

	@Indexed(unique=true)
	private String inChargecontactno;
	
	private String registeredBy;
	
	private String fundExpected;
	private String url;
	
	private String status;
	
}