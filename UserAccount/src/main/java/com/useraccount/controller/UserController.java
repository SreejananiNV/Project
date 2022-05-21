package com.useraccount.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.useraccount.Exception.LogInException;
import com.useraccount.Exception.SignUpException;

import com.useraccount.model.SignUpModel;
import com.useraccount.model.SignUpModelDTO;
import com.useraccount.service.SignUpService;


@RestController
public class UserController {
	@Autowired
	public SignUpService signupser;


	
	
	@PostMapping("/addsignup")
	@CrossOrigin(origins = "http://localhost:4200/")
	public SignUpModelDTO addsignupdetails(@RequestBody SignUpModelDTO signupDTO) throws SignUpException {
		return signupser.saveDetails(signupDTO);
	}

	
	@GetMapping("/getDetails")
	public List<SignUpModel> getDetails(){
		return signupser.getAll();
		
	}
	
 	
	@GetMapping("/getByName/{name}")
	public SignUpModel getByUserName(@PathVariable("name") String Username) {
	     return signupser.findByUserName(Username);
			
		} 
	
	
	@PostMapping("/addlogin")
	@CrossOrigin(origins = "http://localhost:4200")
	public SignUpModel addlogin(@RequestBody SignUpModel login)throws  SignUpException, LogInException{

		return signupser.saveDetails1(login);
		
	}


}
