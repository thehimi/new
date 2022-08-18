package com.wipro.velocity.empowerher.service;

/*import java.time.LocalDate;
import java.util.Optional;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;*/

import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import com.wipro.velocity.empowerher.model.Ngo;
import com.wipro.velocity.empowerher.repository.NgoRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
class NgoServiceTest {

	@Autowired
	NgoService nservice;
	
	@MockBean
	private NgoRepository nrepo;
	
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
		when(nrepo.findAll()).thenReturn(Stream.of(ngo).collect(Collectors.toList()));
		
		assertEquals(1,nservice.getNgoList().size());
	}

	

	@Test
	void getNgoByRegisteredBy() throws IOException 
	{
		String registeredBy="user@gmail.com";
		
		when(nrepo.findByRegisteredBy(registeredBy)).thenReturn(Stream.of(ngo).collect(Collectors.toList()));
		
		assertEquals(1,nservice.getRegisteredBy(registeredBy).size());
		
	}
	
	@Test
	void TestGetNgosBySector() throws IOException 
	{	
		String sector="Agri";
		
		when(nrepo.findByCourseSector(sector)).thenReturn(Stream.of(ngo).collect(Collectors.toList()));
		
		assertEquals(1,nservice.getNgosBySector(sector).size());
	}
	
	/*@Test
	void testDeleteNgo() throws IOException 
	{				
		nservice.deleteNgo(ngo.getId());
		
		verify(nrepo,times(1)).delete(ngo);
	}
	
	@Test
	void testUpdateStatus() throws Exception 
	{		
		when(nrepo.save(ngo)).thenReturn(ngo);
		
		assertEquals(ngo,nservice.updateStatus(ngo.getId(),"Accepted"));
		
		
	}
	
	@Test
	void testAddNgo() throws IOException 
	{	
		when(nrepo.insert(ngo)).thenReturn(ngo);
		
		String id=nservice.addNgo(ngo.getNgoName(), ngo.getNgoState(), ngo.getNgoDistrict(),ngo.getNgoType(),ngo.getNgoUniqueId(),ngo.getNgoEmail(),ngo.getNgoWebsiteLink(),ngo.getCourseName(),
				  ngo.getCourseSector(),ngo.getCourseDuration(),ngo.getCourseMode(),ngo.getMaxPeople(),ngo.getInChargeName(),ngo.getInChargeEmailId(),ngo.getInChargecontactno(),ngo.getFundExpected(),
				  ngo.getRegisteredBy(),ngo.getStatus(), file,ngo.getUrl());
		
		assertEquals(ngo.getId(),id);	
	}

	@Test
	void testGetNgoById() throws IOException 
	{	
		String id="123";
		
		Optional<Ngo> ngo=nrepo.findById(id);
		
		when(nrepo.findById(id)).thenReturn(ngo);
		
		assertEquals(ngo,nservice.getngoById(id));
		
	}
	
	
	@Test
	void testUpdateNgo() throws Exception 
	{	
		when(nrepo.save(ngo)).thenReturn(ngo);

		Ngo ngo1 = nservice.updateNgo("376","Ngo1", "Tamil Nadu", "Erode","Trust",
				"Fdg45jfj","ngo1@gmail.com","www.ngo1.com","Agri for women",
				 "Agriculture","2 months","Offline","30","Raju","raju@gmail.com",
				 "7854123692","500000", file,"/file/quote");
		
		assertEquals(ngo,ngo1);	
	}*/

}