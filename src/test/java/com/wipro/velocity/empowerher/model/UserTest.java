package com.wipro.velocity.empowerher.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

class UserTest 
{
	@MockBean
	User user;

	@BeforeEach
	void setUp() throws Exception 
	{
		user=new User();
	}
	
	@Test
	void testGetId() 
	{
		user.setId("123");
		assertEquals("123",user.getId());
	}	
	
	@Test
	void testFname() 
	{
		user.setFname("First");
		assertEquals("First",user.getFname());
	}
	
	@Test
	void testLname() 
	{
		user.setLname("Last");
		assertEquals("Last",user.getLname());
	}
	
	@Test
	void testClassification() 
	{
		user.setClassification("Trainee");
		assertEquals("Trainee",user.getClassification());
	}
	
	@Test
	void testPassword() 
	{
		user.setPassword("123456");
		assertEquals("123456",user.getPassword());
	}
	
	@Test
	void testConfirmPassword() 
	{
		user.setConfirmPassword("123456");
		assertEquals("123456",user.getConfirmPassword());
	}
	
	
	@Test
	void testEmail() 
	{
		user.setEmail("user@gmail.com");
		assertEquals("user@gmail.com",user.getEmail());
	}
	
	@Test
	void testGetDob() 
	{
		long timestamp = 153251639; 
		Date date = new Date(timestamp);
		user.setDob(date);
		assertEquals(date,user.getDob());
	}
	
	@Test
	void testPhoneNo() 
	{
		user.setPhoneNo("9541236512");
		assertEquals("9541236512",user.getPhoneNo());
	}
}
