package com.useraccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.useraccount.model.SignUpModel;

@Repository
public interface  SignUpRepository extends  JpaRepository<SignUpModel,String> {

	public SignUpModel findByusername(String Username);


	
}
