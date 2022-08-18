package com.wipro.velocity.empowerher.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import com.wipro.velocity.empowerher.model.Trainee;

import com.wipro.velocity.empowerher.service.TraineeService;

@SpringBootTest
@RunWith(SpringRunner.class)
class TraineeControllerTest 
{

	@InjectMocks
	TraineeController traineeController;

	@Mock
	TraineeService tservice;
	
	Trainee trainee;
	
	LocalDate localDate = LocalDate.of(2016, 8, 19);
	
	MockMultipartFile file = new MockMultipartFile("file","hello.txt",
	 MediaType.TEXT_PLAIN_VALUE,"Hello, World!".getBytes());
	
	@BeforeEach
	void setUp() throws Exception 
	{
		trainee=new Trainee("376","Trainee1",localDate,"21","5","2",
				"Married","500000","trainee1@gmail.com","8412365729","Street1",
				"City1","251436","451263465612","Agriculture","Agriculture for Women",
				"user1@gmail.com","Pending",new Binary(BsonBinarySubType.BINARY,
				file.getBytes()),"file/aadhar");
	}
	
	@Test
	void testGetTraineeList() throws IOException 
	{		
		when(tservice.getTraineeList()).thenReturn(Stream.of(trainee).collect(Collectors.toList()));
		
		assertEquals(1,traineeController.getTraineeList().size());
	}
	
	@Test
	void getTraineeByRegisteredBy() throws IOException 
	{		
		String registeredBy="user1@gmail.com";
		
		when(tservice.getRegisteredBy(registeredBy)).thenReturn(Stream.of(trainee).collect(Collectors.toList()));
		
		assertEquals(1,traineeController.getTraineeByRegisteredBy(registeredBy).size());
	}

	@Test
	void testGetTraineeById() 
	{
		String registeredBy="user@gmail.com";
		
		when(tservice.getRegisteredBy(registeredBy)).thenReturn(Stream.of
				(trainee).collect(Collectors.toList()));
		
		assertEquals(1,traineeController.getTraineeByRegisteredBy(registeredBy).size());
	}

	@Test
	void testUpdateStatus() throws Exception 
	{
		when(tservice.updateStatus(trainee.getId(),"Accepted")).thenReturn(trainee);
		
		assertEquals(ResponseEntity.ok().body(trainee),traineeController.updateStatus(trainee.getId(),"Accepted"));
	}

	@Test
	void testDeleteTrainee() 
	{
		traineeController.deleteTrainee(trainee.getId());
		
		verify(tservice,times(1)).deleteTrainee(trainee.getId());
	}
	
	@Test
	void testUpdateTrainee() throws Exception 
	{	
		when(tservice.updateTrainee("376", "Padma", localDate, "30", "4", "0", "single", "570000", "padma@gmail.com",
		"8983167318", "Pk", "AP", "238790", "372890182739", "Agriculture", "E-FARM", file,"/file/Aadhar")).thenReturn(trainee);
		
		assertEquals(ResponseEntity.ok().body(trainee),traineeController.updateTrainee("376", "Padma", localDate, "30", "4", "0", "single", "570000", "padma@gmail.com",
		"8983167318", "Pk", "AP", "238790", "372890182739", "Agriculture", "E-FARM", file,"/file/Aadhar"));
	}
		
	@Test
	void testAddDoc() throws IOException 
	{
		when(tservice.addTrainee("Padma", localDate, "20", "4", "0", "single", "570000",
				"padma@gmail.com", "8983167318", "Pk", "AP", "238790", "372890182739", "Agriculture", "E-FARM",
				"Trainee", "Accpeted", file, "/file/Aadhar")).thenReturn(trainee.getId());

		String id = traineeController.addDoc("Padma", localDate, "20", "4", "0", "single", "570000",
				"padma@gmail.com", "8983167318", "Pk", "AP", "238790", "372890182739", "Agriculture", "E-FARM",
				"Trainee", "Accpeted", file, "/file/Aadhar");
		
		when(tservice.getTraineeById(id)).thenReturn(trainee);
		
		ResponseEntity<Trainee> trainee1= traineeController.getTraineeById(id);
		
		assertEquals(ResponseEntity.ok().body(trainee),trainee1);
	}
}