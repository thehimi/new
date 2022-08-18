package com.wipro.velocity.empowerher.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

class NgoTest 
{
	@MockBean
	Ngo ngo;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		ngo=new Ngo();
	}
	
	@Test
	void testGetId() 
	{
		ngo.setId("123");
		assertEquals("123",ngo.getId());
	}
	
	@Test
	void testMult() throws IOException 
	{
		MockMultipartFile file = new MockMultipartFile("file","hello.txt",
				 MediaType.TEXT_PLAIN_VALUE,"Hello, World!".getBytes());
		
		ngo.setMult(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		assertEquals(new Binary(BsonBinarySubType.BINARY, file.getBytes()),ngo.getMult());
	}
	

	@Test
	void testGetNgoName() 
	{
		ngo.setNgoName("Name");
		assertEquals("Name",ngo.getNgoName());
	}
	
	@Test
	void testNgoState() 
	{
		ngo.setNgoState("State");
		assertEquals("State",ngo.getNgoState());
	}
	
	@Test
	void testNgoDistrict() 
	{
		ngo.setNgoDistrict("District");
		assertEquals("District",ngo.getNgoDistrict());
	}
	
	
	@Test
	void testNgoType() 
	{
		ngo.setNgoType("Trust");
		assertEquals("Trust",ngo.getNgoType());
	}
	
	@Test
	void testNgoUniqueId() 
	{
		ngo.setNgoUniqueId("HSG358GS");
		assertEquals("HSG358GS",ngo.getNgoUniqueId());
	}
	
	@Test
	void testNgoEmail() 
	{
		ngo.setNgoEmail("ngo@gmail.com");
		assertEquals("ngo@gmail.com",ngo.getNgoEmail());
	}
	
	@Test
	void testNgoWebsiteLink() 
	{
		ngo.setNgoWebsiteLink("www.ngo.com");
		assertEquals("www.ngo.com",ngo.getNgoWebsiteLink());
	}
	
	@Test
	void testFundExpected() 
	{
		ngo.setFundExpected("500000");
		assertEquals("500000",ngo.getFundExpected());
	}

	@Test
	void testCourseSector() 
	{
		ngo.setCourseSector("Agriculture");
		assertEquals("Agriculture",ngo.getCourseSector());
	}
	
	@Test
	void testCourseName() 
	{
		ngo.setCourseName("Agriculture for Women");
		assertEquals("Agriculture for Women",ngo.getCourseName());
	}
	
	@Test
	void testCourseDuration() 
	{
		ngo.setCourseDuration("2 months");
		assertEquals("2 months",ngo.getCourseDuration());
	}
	
	@Test
	void testCourseMode() 
	{
		ngo.setCourseMode("Offline");
		assertEquals("Offline",ngo.getCourseMode());
	}
	
	@Test
	void testMaxPeople() 
	{
		ngo.setMaxPeople("50");
		assertEquals("50",ngo.getMaxPeople());
	}
	
	@Test
	void testInChargeName() 
	{
		ngo.setInChargeName("InCharge");
		assertEquals("InCharge",ngo.getInChargeName());
	}
	
	@Test
	void testInChargeEmailId() 
	{
		ngo.setInChargeEmailId("incharge@gmail.com");
		assertEquals("incharge@gmail.com",ngo.getInChargeEmailId());
	}
	
	@Test
	void testInChargecontactno() 
	{
		ngo.setInChargecontactno("7512468216");
		assertEquals("7512468216",ngo.getInChargecontactno());
	}
	
	@Test
	void testRegisteredBy() 
	{
		ngo.setRegisteredBy("user@gmail.com");
		assertEquals("user@gmail.com",ngo.getRegisteredBy());
	}
	
	@Test
	void testStatus() 
	{
		ngo.setStatus("Pending");
		assertEquals("Pending",ngo.getStatus());
	}
	
	@Test
	void testUrl() 
	{
		ngo.setUrl("file/aadhar");
		assertEquals("file/aadhar",ngo.getUrl());
	}

}
