package com.useraccount.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.useraccount.Exception.LogInException;
import com.useraccount.Exception.SignUpException;
import com.useraccount.model.SignUpModel;
import com.useraccount.model.SignUpModelDTO;
import com.useraccount.repository.SignUpRepository;

@Service
public class SignUpService {

	@Autowired
	public SignUpRepository signuprepo;
	
	
	

	public SignUpModelDTO saveDetails(SignUpModelDTO signup1) throws SignUpException {
//		String uername=signup1.getUsername();
//		String hobbies=signup1.getHobbies();
//		int age=signup1.getAge();
//		String gender=signup1.getGender();
//		String passsword=signup1.getPassword();
//		   
//		
//		
//		System.out.println(uername);
//		System.out.println(hobbies);
//		System.out.println(age);
//		System.out.println(gender);
//		System.out.println(passsword);
		StringBuilder hobbies =new StringBuilder();
		for (String hobby:signup1.getHobbies())
		{
			hobbies.append(hobby);
			hobbies.append(",");
		}
		SignUpModel signUpModel=new SignUpModel();
		signUpModel.setUsername(signup1.getUsername());
		signUpModel.setPassword(signup1.getPassword());
		signUpModel.setAge(signup1.getAge());
		signUpModel.setGender(signup1.getGender());
		signUpModel.setHobbies(hobbies.toString());
		
		SignUpModelDTO signUpDTO=new SignUpModelDTO();
		if (signuprepo.existsById(signUpModel.getUsername())) {	
			signUpDTO.setMsg("User Name Already Exists !!");
			//throw new SignUpException("User Already Exist!!!, Try login");
		}
		else
		{
			signuprepo.save(signUpModel);
			signUpDTO.setMsg("User Name Successfully Registered !!");
		}
		return signUpDTO;
	}

	


	public SignUpModel findByUserName(String username) {
	
		return signuprepo.findByusername(username);
	}


	public List<SignUpModel> getAll() {
	
		return signuprepo.findAll();
	}


	public SignUpModel saveDetails1(SignUpModel login) throws SignUpException, LogInException  {
		String user=login.getUsername();
		String pass=login.getPassword();
		if(signuprepo.existsById(user)) {
			if(signuprepo.findByusername(user).getPassword().equals(pass)) {
				System.out.println("Login Success");
				return login;
			}
			else
			{
				throw new LogInException("Incorrect Password!!!");
			}
		}
		else
		{
			throw new LogInException("User Doesn't exist!!!");
		}
		
	
	}
	
}















