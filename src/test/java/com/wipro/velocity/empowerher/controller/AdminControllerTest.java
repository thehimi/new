package com.wipro.velocity.empowerher.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;


import com.wipro.velocity.empowerher.model.Admin;
import com.wipro.velocity.empowerher.repository.AdminRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class AdminControllerTest {

	@InjectMocks
	AdminController adminController;

	@Mock
	AdminRepository arepo;
	
	
	@Test
	public void testLoginAdmin() throws ParseException, IOException 
	{
		Admin admin = new Admin(null,"admin","admin123");
		
		when(arepo.findByUserName("admin")).thenReturn(admin);
		
		assertEquals(Boolean.TRUE, adminController.loginUser(admin));
		
	}
	
}