package com.springboot.__user_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.__user_management_system.dto.ResponseUser;
import com.springboot.__user_management_system.dto.UserUpdate;
import com.springboot.__user_management_system.entity.User;
import com.springboot.__user_management_system.exception.InvalidAgeException;
import com.springboot.__user_management_system.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController { 
	
	// inject user service
	@Autowired
	private UserService userService;

	// create user
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<User>(savedUser , HttpStatus.CREATED);
	}
	
	// read user by id
//	@GetMapping("/{id}")
//	public ResponseEntity<Users> readUser(@PathVariable long id){
//	ResponseUser readuser = userService.findUser(id);
//		Users readuser = userService.findUser(id);
//		return new ResponseEntity<Users>(readuser , HttpStatus.OK);
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> readUser(@PathVariable long id) {
	    ResponseUser readuser = userService.findUser(id);
	    return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	// read all users
	@GetMapping
	public ResponseEntity<List<User>> findAllUser(){
		List <User> Users =  userService.findAllUser();
		return new ResponseEntity<>(Users , HttpStatus.OK); 
	}
	
	// update user
	@PutMapping("/{id}")
	public ResponseEntity<User> modifyUser(
			@PathVariable long id,
			@RequestBody UserUpdate userUpdate){
				User user = userService.updateUser(id,userUpdate);
				return new ResponseEntity<>(user , HttpStatus.OK); 
			}
	
	// delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeUser(@PathVariable long id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
//
//	@ExceptionHandler(InvalidAgeException.class)
//	public ResponseEntity<String> handleInvalidAgeException(InvalidAgeException ex){
//		return new ResponseEntity <String> (ex.getMessage(),HttpStatus.BAD_REQUEST);
//	}
	
}