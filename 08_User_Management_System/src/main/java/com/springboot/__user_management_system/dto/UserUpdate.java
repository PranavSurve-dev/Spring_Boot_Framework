package com.springboot.__user_management_system.dto;

//This class is used to update the user details. 
//It is used in the UserController class to update the user details. 
//It is also used in the UserService class to update the user details. 
//It is also used in the UserRepository class to update the user details.


public record UserUpdate(String name, int age, String email,String password) {

}
