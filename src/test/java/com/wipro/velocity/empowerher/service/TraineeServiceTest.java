package com.wipro.velocity.empowerher.service;

/*import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;*/

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;


import com.wipro.velocity.empowerher.model.Trainee;
import com.wipro.velocity.empowerher.repository.TraineeRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class TraineeServiceTest 
{
	@Autowired
	TraineeService tservice;
	
	@MockBean
	private TraineeRepository trepo;
	
	
	LocalDate localDate = LocalDate.of(2016, 8, 19);
	
	MockMultipartFile file = new MockMultipartFile("file","hello.txt",
	 MediaType.TEXT_PLAIN_VALUE,"Hello, World!".getBytes());
	
	@Test
	void testGetTraineeList() throws IOException 
	{
		Trainee trainee=new Trainee("376","Trainee1",localDate,"21","5","2",
				"Married","500000","trainee1@gmail.com","8412365729","Street1",
				"City1","251436","451263465612","Agriculture","Agriculture for Women",
				"user1@gmail.com","Pending",new Binary(BsonBinarySubType.BINARY,
				file.getBytes()),"file/aadhar");
		
		when(trepo.findAll()).thenReturn(Stream.of(trainee).collect(Collectors.toList()));
		
		assertEquals(1,tservice.getTraineeList().size());
	}
	
	@Test
	void getTraineeByRegisteredBy() throws IOException 
	{
		String registeredBy="user1@gmail.com";
		
		Trainee trainee=new Trainee("376","Trainee1",localDate,"21","5","2",
				"Married","500000","trainee1@gmail.com","8412365729","Street1",
				"City1","251436","451263465612","Agriculture","Agriculture for Women",
				"user1@gmail.com","Pending",new Binary(BsonBinarySubType.BINARY,
				file.getBytes()),"file/aadhar");
		
		when(trepo.findByRegisteredBy(registeredBy)).thenReturn(Stream.of(trainee).collect(Collectors.toList()));
		assertEquals(1,tservice.getRegisteredBy(registeredBy).size());
		
	}


	/*@Test
	void testAddTrainee() throws IOException 
	{		
		String id= tservice.addTrainee("Padma", localDate, "20", "4", "0", "single", "570000",
				"padma@gmail.com", "8983167318", "Pk", "AP", "238790", "372890182739", "Agriculture", "E-FARM",
				"Trainee", "Accpeted", file, "/file/Aadhar");

		assertThat(id).isNotEmpty();
	}

	@Test
	void testGetTraineeById() throws IOException 
	{
		String id= tservice.addTrainee("Padma", localDate, "20", "4", "0", "single", "570000",
				"padma@gmail.com", "8983167318", "Pk", "AP", "238790", "372890182739", "Agriculture", "E-FARM",
				"Trainee", "Accpeted", file, "/file/Aadhar");
		
		trainee = tservice.getTraineeById(id);

		assertThat(trainee).isNotNull();
	}
	
	@Test
	void testUpdateStatus() throws Exception 
	{	
		String id= tservice.addTrainee("Padma", localDate, "20", "4", "0", "single", "570000",
				"padma@gmail.com", "8983167318", "Pk", "AP", "238790", "372890182739", "Agriculture", "E-FARM",
				"Trainee", "Accpeted", file, "/file/Aadhar");

		assertThat(tservice.updateStatus(id, "Accepted")).isNotNull();

	}

	@Test
	void testDeleteTrainee() throws IOException 
	{
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Deleted the Trainee", Boolean.TRUE);
		
		String id= tservice.addTrainee("Padma", localDate, "20", "4", "0", "single", "570000",
				"padma@gmail.com", "8983167318", "Pk", "AP", "238790", "372890182739", "Agriculture", "E-FARM",
				"Trainee", "Accpeted", file, "/file/Aadhar");
		
		assertThat(tservice.deleteTrainee(id)).isEqualTo(response);
	}
	
	
	@Test
	void testUpdateTrainee() throws Exception 
	{		
		String id= tservice.addTrainee("Padma", localDate, "20", "4", "0", "single", "570000",
				"padma@gmail.com", "8983167318", "Pk", "AP", "238790", "372890182739", "Agriculture", "E-FARM",
				"Trainee", "Accpeted", file, "/file/Aadhar");

		Trainee trainee = tservice.updateTrainee(id, "Padma", localDate, "30", "4", "0", "single", "570000", "padma@gmail.com",
				"8983167318", "Pk", "AP", "238790", "372890182739", "Agriculture", "E-FARM", file,"/file/Aadhar");

		assertThat(trainee).isNotNull();
	}*/
}