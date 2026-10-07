package com.springboot.__user_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.__user_management_system.dto.UserUpdate;
import com.springboot.__user_management_system.entity.Users;
import com.springboot.__user_management_system.exception.InvalidAgeException;
import com.springboot.__user_management_system.exception.UserNotFonudExceprion;
import com.springboot.__user_management_system.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository; 

	// business logic
	public Users saveUser(Users user) {
		if(user.getAge()<18)
			throw new InvalidAgeException("Your age is less than 18");
		return userRepository.save(user);
	}
	
	// find user by id
	public Users findUser(long id) {
		Optional<Users> optional = userRepository.findById(id);
		if (optional.isPresent())
		return optional.get();
		throw new UserNotFonudExceprion("User with id "+id+"id is not found");
	}
	// find all users
	public List<Users> findAllUser(){
		return userRepository.findAll();
	}
	
	// update user
	public Users updateUser(long id, UserUpdate userUpdate) {
		Users user = findUser(id);
		user.setName(userUpdate.getName());
		user.setAge(userUpdate.getAge());
		user.setEmail(userUpdate.getEmail());
		user.setPassword(userUpdate.getPassword());
		
		// save the updated user
		return userRepository.save(user);
	}
	
	  // delete user
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}


	
}
