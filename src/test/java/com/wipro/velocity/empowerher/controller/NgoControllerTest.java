package com.wipro.velocity.empowerher.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

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

import com.wipro.velocity.empowerher.model.Ngo;
import com.wipro.velocity.empowerher.service.NgoService;

@SpringBootTest
@RunWith(SpringRunner.class)
class NgoControllerTest 
{

	@InjectMocks
	NgoController ngoController;

	@Mock
	NgoService nservice;
	
	MockMultipartFile file = new MockMultipartFile("file","hello.txt",
			 MediaType.TEXT_PLAIN_VALUE,"Hello, World!".getBytes());
	
	Ngo ngo;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		ngo=new Ngo("376",new Binary(BsonBinarySubType.BINARY, file.getBytes()),
				"Ngo1","State1","District1","Type1","GH653F","ngo1@gmail.com",
				"ngo1@gmail.com","Agri for Women","Agri","2 months","Offline","50",
				"Raghu","raghu@gmail.com","7512463289","user@gmail.com","500000",
				"fil1/aadhar","Accepted");
	}

	
	@Test
	void testGetNgoList() throws IOException 
	{
		when(nservice.getNgoList()).thenReturn(Stream.of(ngo).collect(Collectors.toList()));
		
		assertEquals(1,ngoController.getNgoList().size());	
	}
	
	@Test
	void testGetNgoByRegisteredBy() throws IOException 
	{

		String registeredBy="user@gmail.com";
		
		when(nservice.getRegisteredBy(registeredBy)).thenReturn(Stream.of
				(ngo).collect(Collectors.toList()));
		
		assertEquals(1,ngoController.getNgoByRegisteredBy(registeredBy).size());
	}
	
	@Test
	void testGetNgosBySector() throws IOException 
	{		
		String sector="Agri";
		
		when(nservice.getNgosBySector(sector)).thenReturn(Stream.of
				(ngo).collect(Collectors.toList()));
		
		
		assertEquals(1,ngoController.getNgosBySector(sector).size());
	}
	
	@Test
	void testGetNgoById() 
	{
		String id="123";
		
		when(nservice.getngoById(id)).thenReturn(ngo);
		
		assertEquals(ResponseEntity.ok().body(ngo),ngoController.getNgoById(id));
	}
	
	@Test
	void testUpdateStatus() throws Exception 
	{
		when(nservice.updateStatus(ngo.getId(),"Accepted")).thenReturn(ngo);
		
		assertEquals(ResponseEntity.ok().body(ngo),ngoController.updateStatus(ngo.getId(),"Accepted"));
	}
	
	@Test
	void testUpdateNgo() throws Exception 
	{
		when(nservice.updateNgo("Ngo1", "Andra Pradesh", "Erode","Trust","uid1","ngo1@gmail.com","www.ngo1.com","Agriculture for Women",
				  "Agriculture","3 months","Online","50","Ragothaman","incharge@gmail.com","6587412546","500000",
				  "user@gmail.com",file,"file/Aadhar")).thenReturn(ngo);
		
		assertEquals(ResponseEntity.ok().body(ngo),ngoController.updateNgo("Ngo1", "Andra Pradesh", "Erode","Trust","uid1","ngo1@gmail.com","www.ngo1.com","Agriculture for Women",
				  "Agriculture","3 months","Online","50","Ragothaman","incharge@gmail.com","6587412546","500000",
				  "user@gmail.com",file,"file/Aadhar"));
	}
	
	@Test
	void testDeleteNgo() 
	{
		ngoController.deleteNgo(ngo.getId());
		
		verify(nservice,times(1)).deleteNgo(ngo.getId());
	}

	@Test
	void testAddDoc() throws IOException 
	{	
		when(nservice.addNgo(ngo.getNgoName(), ngo.getNgoState(), ngo.getNgoDistrict(),ngo.getNgoType(),ngo.getNgoUniqueId(),ngo.getNgoEmail(),ngo.getNgoWebsiteLink(),ngo.getCourseName(),
				  ngo.getCourseSector(),ngo.getCourseDuration(),ngo.getCourseMode(),ngo.getMaxPeople(),ngo.getInChargeName(),ngo.getInChargeEmailId(),ngo.getInChargecontactno(),ngo.getFundExpected(),
				  ngo.getRegisteredBy(),ngo.getStatus(), file,ngo.getUrl())).thenReturn(ngo.getId());
		
		String id= ngoController.addDoc("Ngo1", "Andra Pradesh", "Erode","Trust","uid1","ngo1@gmail.com","www.ngo1.com","Agriculture for Women",
				  "Agriculture","3 months","Online","50","Ragothaman","incharge@gmail.com","6587412546","500000",
				  "user@gmail.com","Pending", file,"file/Aadhar");
		
		when(nservice.getngoById(id)).thenReturn(ngo);
		
		ResponseEntity<Ngo> ngo1= ngoController.getNgoById(id);
		
		assertEquals(ResponseEntity.ok().body(ngo),ngo1);	
	}
}