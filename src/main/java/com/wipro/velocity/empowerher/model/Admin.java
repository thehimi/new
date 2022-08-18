package com.wipro.velocity.empowerher.model;


import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="admin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Admin 
{
	@Id
    private String id;
	
	@Indexed(unique=true)
	private String userName;
	
	private String password;

}
