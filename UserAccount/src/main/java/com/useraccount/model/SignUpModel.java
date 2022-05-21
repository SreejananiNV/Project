package com.useraccount.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SignUpModel {
	
	
	@Id
	private  String username;
	private int age;
	

	private String gender;
	private String hobbies;
	private String password;
	
	
	
	public   String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public  String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public SignUpModel(String username, int age, String gender, String hobbies, String password) {
		super();
		this.username = username;
		this.age = age;
		this.gender = gender;
		this.hobbies = hobbies;
		this.password = password;
	}
	public SignUpModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SignUpModel [username=" + username + ", age=" + age + ", gender=" + gender + ", hobbies=" + hobbies
				+ ", password=" + password + "]";
	}
	

}
