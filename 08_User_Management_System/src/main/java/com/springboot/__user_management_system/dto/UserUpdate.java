package com.springboot.__user_management_system.dto;


// This class is used to update the user details. 
//It is used in the UserController class to update the user details. 
//It is also used in the UserService class to update the user details. 
//It is also used in the UserRepository class to update the user details.
public class UserUpdate {

	private String name;
	private int age;
	private String email;
	private String password;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
