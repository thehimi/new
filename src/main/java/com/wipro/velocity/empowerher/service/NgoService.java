package com.wipro.velocity.empowerher.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.velocity.empowerher.model.Ngo;
import com.wipro.velocity.empowerher.repository.NgoRepository;

@Service
public class NgoService 
{
	@Autowired
	 private NgoRepository nfrepo;
	
	 
	 public String addNgo(String ngoName, String ngoState, String ngoDist, String ngoType, String ngoUniqueId,
			 String ngoEmail, String ngoWebLink, String courseName, String coursesector, String courseDur,
			 String courseMode, String maxPeople, String inChargeName, String inChargeEmail, String inChargeContactNo,
			 String fundExpected,String registeredBy,String status, MultipartFile mult, String url) throws IOException
	 {
	  Ngo nf=new Ngo();
	  nf.setNgoName(ngoName);
	  nf.setNgoState(ngoState);
	  nf.setNgoDistrict(ngoDist);
	  nf.setNgoType(ngoType);
	  nf.setNgoUniqueId(ngoUniqueId);
	  nf.setNgoEmail(ngoEmail);
	  nf.setNgoWebsiteLink(ngoWebLink);
	  nf.setCourseName(courseName);
	  nf.setCourseSector(coursesector);
	  nf.setCourseDuration(courseDur);
	  nf.setCourseMode(courseMode);
	  nf.setMaxPeople(maxPeople);
	  nf.setInChargeName(inChargeName);
	  nf.setInChargeEmailId(inChargeEmail);
	  nf.setInChargecontactno(inChargeContactNo);
	  nf.setFundExpected(fundExpected);
	  nf.setRegisteredBy(registeredBy);
	  nf.setStatus(status);
	  nf.setMult(new Binary(BsonBinarySubType.BINARY, mult.getBytes()));
	  nf.setUrl(url);
	  
	  nf=nfrepo.insert(nf);
	  return nf.getId();
	 
	 }
	 
	 public Ngo getngoById(String id) 
	 { 
	        return nfrepo.findById(id).get(); 
	 }
	 
	 public Ngo updateNgo(String id,String ngoName, String ngoState, String ngoDist, String ngoType, String ngoUniqueId,
			 String ngoEmail, String ngoWebLink, String courseName, String coursesector, String courseDur,
			 String courseMode, String maxPeople, String inChargeName, String inChargeEmail, String inChargeContactNo,
			 String fundExpected, MultipartFile file,String url) throws IOException
	 {
		 
		  Ngo nf=nfrepo.findById(id).get(); 
		 
		  nf.setNgoName(ngoName);
		  nf.setNgoState(ngoState);
		  nf.setNgoDistrict(ngoDist);
		  nf.setNgoType(ngoType);
		  nf.setNgoUniqueId(ngoUniqueId);
		  nf.setNgoEmail(ngoEmail);
		  nf.setNgoWebsiteLink(ngoWebLink);
		  nf.setCourseName(courseName);
		  nf.setCourseSector(coursesector);
		  nf.setCourseDuration(courseDur);
		  nf.setCourseMode(courseMode);
		  nf.setMaxPeople(maxPeople);
		  nf.setInChargeName(inChargeName);
		  nf.setInChargeEmailId(inChargeEmail);
		  nf.setInChargecontactno(inChargeContactNo);
		  nf.setFundExpected(fundExpected);
		  
		  nf.setMult(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		  nf.setUrl(url);
		  
		  nf=nfrepo.save(nf);
    	
    	 return nf;
	 }
	 
	 public Ngo updateStatus(String id,String status) throws IOException
	 {
		 
		  Ngo nf=nfrepo.findById(id).get(); 
		  
		  nf.setStatus(status);
		  
		  nf=nfrepo.save(nf);
    	
    	 return nf;
	 }
	 
	 public List<Ngo> getNgoList()
		{
			return nfrepo.findAll();
		}
	 
	 
	 public Map<String,Boolean> deleteNgo(String nId) 
	 {
		 Ngo ngo=nfrepo.findById(nId).get();
	    
		 nfrepo.delete(ngo);
		 Map<String, Boolean> response=new HashMap<>();
		    response.put("Deleted the Ngo", Boolean.TRUE);
		    return response;
	 }
	 public List<Ngo> getNgosBySector(String courseSector)
	 {
		//invokes findBySector() custom method of MongoRepository
	  		return (List<Ngo>) nfrepo.findByCourseSector(courseSector);  //invokes findAll() method of MongoRepository
	 }
	 
	 public List<Ngo> getRegisteredBy(String registeredBy)
	 {
		 return (List<Ngo>) nfrepo.findByRegisteredBy(registeredBy);
	 }
}
