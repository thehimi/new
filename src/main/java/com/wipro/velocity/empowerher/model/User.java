package com.wipro.velocity.empowerher.model;

import java.util.Date;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User 
{
	@Id
    private String id;
	
	@Indexed(unique=true)
    private String email;
    private String fname;
    private String lname;
    
    private String classification; //user/trainee
    
    private String password;
    private String confirmPassword;
    
    private Date dob;
    
    @Indexed(unique=true)
    private String phoneNo;
	
}