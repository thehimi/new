package com.wipro.velocity.empowerher.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

class AdminTest {

	@MockBean
	Admin admin;

	@BeforeEach
	void setUp() throws Exception 
	{
		admin=new Admin();
	}
	
	@Test
	void testGetId() 
	{
		admin.setId("123");
		assertEquals("123",admin.getId());
	}
	
	@Test
	void testUserName() 
	{
		admin.setUserName("Username");
		assertEquals("Username",admin.getUserName());
	}
	
	@Test
	void testPassword() 
	{
		admin.setPassword("123456");
		assertEquals("123456",admin.getPassword());
	}


}
