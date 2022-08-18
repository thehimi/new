package com.wipro.velocity.empowerher.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;


class TraineeTest 
{
	@MockBean
	Trainee trainee;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		trainee=new Trainee();
	}

	
	@Test
	void testGetTraineeId() 
	{
		trainee.setId("123");
		assertEquals("123",trainee.getId());
	}
	

	@Test
	void testGetTraineeName() 
	{
		trainee.setTraineeName("Name");
		assertEquals("Name",trainee.getTraineeName());
	}
	
	@Test
	void testGetDob() 
	{
		LocalDate localDate = LocalDate.of(2016, 8, 19);
		trainee.setDob(localDate);
		assertEquals(localDate,trainee.getDob());
	}
	
	@Test
	void testAge() 
	{
		trainee.setAge("20");
		assertEquals("20",trainee.getAge());
	}
	
	@Test
	void testNoOfMembers() 
	{
		trainee.setNoOfMembers("5");
		assertEquals("5",trainee.getNoOfMembers());
	}
	
	@Test
	void testNoOfChildren() 
	{
		trainee.setNoOfChildren("1");
		assertEquals("1",trainee.getNoOfChildren());
	}
	
	@Test
	void testMaritalStatus() 
	{
		trainee.setMaritalStatus("Single");
		assertEquals("Single",trainee.getMaritalStatus());
	}
	
	@Test
	void testAnnualIncome() 
	{
		trainee.setAnnualIncome("500000");
		assertEquals("500000",trainee.getAnnualIncome());
	}
	
	@Test
	void testEmail() 
	{
		trainee.setEmail("trainee@gmail.com");
		assertEquals("trainee@gmail.com",trainee.getEmail());
	}
	
	@Test
	void testContactNumber() 
	{
		trainee.setContactNumber("9541236512");
		assertEquals("9541236512",trainee.getContactNumber());
	}
	
	@Test
	void testStreet() 
	{
		trainee.setStreet("Street1");
		assertEquals("Street1",trainee.getStreet());
	}
	
	@Test
	void testCity() 
	{
		trainee.setCity("City1");
		assertEquals("City1",trainee.getCity());
	}
	
	@Test
	void testPincode() 
	{
		trainee.setPincode("600028");
		assertEquals("600028",trainee.getPincode());
	}
	
	@Test
	void testAdhaarNo() 
	{
		trainee.setAdhaarNo("321452126589");
		assertEquals("321452126589",trainee.getAdhaarNo());
	}
	
	@Test
	void testCourseSector() 
	{
		trainee.setCourseSector("Agriculture");
		assertEquals("Agriculture",trainee.getCourseSector());
	}
	
	@Test
	void testCourseName() 
	{
		trainee.setCourseName("Agriculture for Women");
		assertEquals("Agriculture for Women",trainee.getCourseName());
	}
	
	@Test
	void testRegisteredBy() 
	{
		trainee.setRegisteredBy("user@gmail.com");
		assertEquals("user@gmail.com",trainee.getRegisteredBy());
	}
	
	@Test
	void testStatus() 
	{
		trainee.setStatus("Pending");
		assertEquals("Pending",trainee.getStatus());
	}
	
	@Test
	void testFile() throws IOException 
	{
		MockMultipartFile file = new MockMultipartFile("file","hello.txt",
				 MediaType.TEXT_PLAIN_VALUE,"Hello, World!".getBytes());
		
		trainee.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		assertEquals(new Binary(BsonBinarySubType.BINARY, file.getBytes()),trainee.getFile());
	}
	
	@Test
	void testUrl() 
	{
		trainee.setUrl("file/aadhar");
		assertEquals("file/aadhar",trainee.getUrl());
	}
	
	
}
