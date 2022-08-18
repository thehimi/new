package com.wipro.velocity.empowerher.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.velocity.empowerher.model.Ngo;
import com.wipro.velocity.empowerher.service.NgoService;

@RestController
@CrossOrigin(origins="https://women-emp-359811.el.r.appspot.com")
@RequestMapping("/api")
public class NgoController 
{
	@Autowired
	 private NgoService ngofs;
	
	//POST- // http://localhost:9095/wep/api/registerNgo 
	 @PostMapping("/registerNgo")
	 public String addDoc(@RequestParam("ngoName") String ngoName,@RequestParam("ngoState") String ngoState,
			 @RequestParam("ngoDistrict") String ngoDistrict, @RequestParam("ngoType") String ngoType,
			 @RequestParam("ngoUniqueId") String ngoUniqueId, @RequestParam("ngoEmail") String ngoEmail,
			 @RequestParam("ngoWebsiteLink") String ngoWebsiteLink,@RequestParam("courseName") String courseName,
			 @RequestParam("courseSector") String courseSector, @RequestParam("courseDuration") String courseDuration,
			 @RequestParam("courseMode") String courseMode, @RequestParam("maxPeople") String maxPeople,
			 @RequestParam("inChargeName") String inChargeName, @RequestParam("inChargeEmailId") String inChargeEmailId,
			 @RequestParam("inChargeContactNo") String inChargeContactNo, @RequestParam("fundExpected") String fundExpected,
			 @RequestParam("status") String status, @RequestParam("registeredBy") String registeredBy, @RequestParam("file") MultipartFile mult,
			 @RequestParam("url") String url) throws IOException  
	 {
	  String id= ngofs.addNgo(ngoName, ngoState, ngoDistrict,ngoType,ngoUniqueId,ngoEmail,ngoWebsiteLink,courseName,
			  courseSector,courseDuration,courseMode,maxPeople,inChargeName,inChargeEmailId,inChargeContactNo,fundExpected,
			  registeredBy,status, mult,url);
	  return id;
	 }	
	 
	//GET- // http://localhost:9095/wep/api/findAllNgos
	 @GetMapping("/findAllNgos")
	 public List<Ngo> getNgoList()
		{
			return ngofs.getNgoList();
		}
	 
	// GET - http://localhost:9095/wep/api/ngo/62c09e09c1472e1500a7116d
	 @GetMapping("/ngo/{id}")
	 public ResponseEntity<Ngo> getNgoById(@PathVariable String id) 
	 {
	     Ngo ngoFile = ngofs.getngoById(id);
	     return ResponseEntity.ok().body(ngoFile);
	 }
	 
	 
	// PUT - http://localhost:9095/wep/api/ngos/101
	 @PutMapping("/ngos/{id}")
	    public ResponseEntity<Ngo> updateNgo(@PathVariable(value="id") String nId,
	    		@Validated @RequestParam("ngoName") String ngoName,@RequestParam("ngoState") String ngoState,
				 @RequestParam("ngoDistrict") String ngoDistrict, @RequestParam("ngoType") String ngoType,
				 @RequestParam("ngoUniqueId") String ngoUniqueId, @RequestParam("ngoEmail") String ngoEmail,
				 @RequestParam("ngoWebsiteLink") String ngoWebsiteLink,@RequestParam("courseName") String courseName,
				 @RequestParam("courseSector") String courseSector, @RequestParam("courseDuration") String courseDuration,
				 @RequestParam("courseMode") String courseMode, @RequestParam("maxPeople") String maxPeople,
				 @RequestParam("inChargeName") String inChargeName, @RequestParam("inChargeEmailId") String inChargeEmailId,
				 @RequestParam("inChargeContactNo") String inChargeContactNo, @RequestParam("fundExpected") String fundExpected,
				 @RequestParam("file") MultipartFile mult, @RequestParam("url") String url) throws Exception
	    {
		 Ngo ngofile=ngofs.updateNgo(nId, ngoName, ngoState, ngoDistrict,ngoType,ngoUniqueId,ngoEmail,ngoWebsiteLink,courseName,
				  courseSector,courseDuration,courseMode,maxPeople,inChargeName,inChargeEmailId,inChargeContactNo,fundExpected, mult,url);
		 
	    	 return ResponseEntity.ok().body(ngofile);
	    }
	 
	 @PutMapping("/ngo/{id}")
	    public ResponseEntity<Ngo> updateStatus(@PathVariable(value="id") String nId,
	    		@Validated @RequestParam("status") String status) throws Exception
	    {
		 Ngo ngofile=ngofs.updateStatus(nId,status);
		 
	    	 return ResponseEntity.ok().body(ngofile);
	    }
	 
	// DELETE - http://localhost:9095/wep/api/ngos/101
	    @DeleteMapping("ngos/{id}")
	    public Map<String,Boolean> deleteNgo(@PathVariable(value="id") String nId)
	     {
		    
		    return ngofs.deleteNgo(nId);
	     }
	    
	 // GET - http://localhost:9095/wep/api/getngosbysector/Agriculture
	  	@GetMapping("/getngosbysector/{courseSector}")
	  	public List<Ngo> getNgosBySector(@PathVariable(value="courseSector") String coursesector)
	  	{
	  		//invokes findBySector() custom method of MongoRepository
	  		return ngofs.getNgosBySector(coursesector);  //invokes findAll() method of MongoRepository
	  		
	  	}
	  	
	 // GET - http://localhost:9095/wep/api/getngosbyregisteredby/
	  	@GetMapping("/getngosbyregisteredby/{registeredBy}")
	  	public List<Ngo> getNgoByRegisteredBy(@PathVariable(value="registeredBy") String registeredBy)
	  	{
	  		//invokes findBySector() custom method of MongoRepository
	  		return ngofs.getRegisteredBy(registeredBy);  //invokes findAll() method of MongoRepository
	  		
	  	}
	 
}