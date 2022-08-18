package com.wipro.velocity.empowerher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.wipro.velocity.empowerher.model.User;
import com.wipro.velocity.empowerher.repository.UserRepository;


@RestController
@CrossOrigin(origins="https://women-emp-359811.el.r.appspot.com")
@RequestMapping("/api")
public class UserController 
{
	@Autowired
	private UserRepository urepo;
	
	//POST -http://localhost:9095/wep/api/registerUser
	@PostMapping("/registerUser")
	public User saveUser(@RequestBody User user)
	{
		urepo.save(user);
		
		return user;
	}
	
	//GET- http://localhost:9095/wep/api/findAllUsers
	@GetMapping("/findAllUsers")
	public List<User> getUserList()
	{
		return urepo.findAll();
	}
	
	//POST- http://localhost:9095/wep/api/loginUser
	@PostMapping("/loginUser")
	public Boolean loginUser(@Validated @RequestBody User user)
	{
		Boolean isLogin=false;
		
		String email=user.getEmail();
	    String password=user.getPassword();
	    String classification=user.getClassification();
	    User u=urepo.findByEmail(email);
	    
	    if(u!=null)
	    {
	    	if(email.equals(u.getEmail()) && password.equals(u.getPassword()) && classification.equals(u.getClassification()))
		    {
		    	isLogin=true;
		    }
	    }
	    return isLogin;
	}
}