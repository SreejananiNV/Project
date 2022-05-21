package com.useraccount.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.useraccount.Exception.LogInException;
import com.useraccount.Exception.SignUpException;
import com.useraccount.model.SignUpModel;
import com.useraccount.model.SignUpModelDTO;

@SpringBootTest
public class SignUpServiceTest {

	@Autowired
	SignUpService sUSer;


	@Test
	public void saveDetailsTest() throws SignUpException {
		SignUpModelDTO sUModel = new SignUpModelDTO();
		
		sUModel.setAge(22);
		sUModel.setGender("Male");
		//sUModel.setHobbies("playing cricket");
		sUModel.setPassword("Password@01");
		sUModel.setUsername("Sample01");

		/*
		 * SignUpModel check = sUSer.saveDetails(sUModel);
		 * 
		 * assertNotNull(check);
		 */
	}
	

	@Test
	public void findByUserNameTest() {
		assertNotNull(sUSer.findByUserName("Sample"));
	}

	@Test
	public void getAllTest() {
		assertNotNull(sUSer.getAll());
	}

	@Test
	public void saveDetails1Test() throws SignUpException, LogInException {
		SignUpModel sUModel = new SignUpModel();
		
		sUModel.setPassword("Password@01");
		sUModel.setUsername("Sample");
		
		assertNotNull(sUSer.saveDetails1(sUModel));
	}
}
