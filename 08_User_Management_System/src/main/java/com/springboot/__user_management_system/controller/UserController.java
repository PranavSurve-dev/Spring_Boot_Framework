package com.springboot.__user_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.__user_management_system.dto.UserUpdate;
import com.springboot.__user_management_system.entity.Users;
import com.springboot.__user_management_system.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController { 
	
	// inject user service
	@Autowired
	private UserService userService;

	// create user
	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody Users user){
		Users savedUser = userService.saveUser(user);
		return new ResponseEntity<Users>(savedUser , HttpStatus.CREATED);
	}
	
	// read user by id
	@GetMapping("/{id}")
	public ResponseEntity<Users> readUser(@PathVariable long id){
		Users readuser = userService.findUser(id);
		return new ResponseEntity<Users>(readuser , HttpStatus.OK);
	}
	
	// read all users
	@GetMapping
	public ResponseEntity<List<Users>> findAllUser(){
		List <Users> Users =  userService.findAllUser();
		return new ResponseEntity<>(Users , HttpStatus.OK); 
	}
	
	// update user
	@PutMapping("/{id}")
	public ResponseEntity<Users> modifyUser(
			@PathVariable long id,
			@RequestBody UserUpdate userUpdate){
				Users user = userService.updateUser(id,userUpdate);
				return new ResponseEntity<>(user , HttpStatus.OK); 
			}
	
	// delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeUser(@PathVariable long id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}