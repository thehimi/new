package com.wipro.velocity.empowerher.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.wipro.velocity.empowerher.model.User;
import com.wipro.velocity.empowerher.repository.UserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserRepository urepo;
	User user;

	@BeforeEach
	void setUp() throws Exception 
	{
		user=new User();
	}

	@Test
	public void testSaveUser() throws ParseException 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date yourDate = sdf.parse("1992-07-26");
		
		user = new User("user21", "user@yahoo.com", "user", "D", "trainee", 
				"user@123", "user@123", yourDate,"8372833292");

		when(urepo.save(any(User.class))).thenReturn(user);

		User user1 = userController.saveUser(user);

		assertEquals(user,user1);
	}

	@Test
	public void testGetUserList() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d1 = sdf.parse("1992-07-26");
		java.util.Date d2 = sdf.parse("1996-07-26");

		when(urepo.findAll()).thenReturn(Stream.of(
				new User("user22", "user2@yahoo.com", "user2", "D", "trainee", "user@1234", "user@1234", d1,
						"8372835292"),
				new User("user23", "user3@yahoo.com", "user3", "D", "trainee", "user@12345", "user@12345", d2,
						"8372833292"))
				.collect(Collectors.toList()));
		assertEquals(2, userController.getUserList().size());

	}
	
	@Test
	public void testLoginUser() throws ParseException, IOException 
	{	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date yourDate = sdf.parse("1992-07-26");
		
		user = new User("user21", "user@yahoo.com", "user", "D", "trainee", "user@123", "user@123", yourDate,
				"8372833292");
		
		when(urepo.findByEmail("user@yahoo.com")).thenReturn(user);
		
		assertEquals(Boolean.TRUE, userController.loginUser(user));
	}
	
}