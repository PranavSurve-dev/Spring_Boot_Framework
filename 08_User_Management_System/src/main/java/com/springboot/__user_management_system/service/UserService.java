package com.springboot.__user_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.__user_management_system.dto.ResponseUser;
import com.springboot.__user_management_system.dto.UserUpdate;
import com.springboot.__user_management_system.entity.User;
import com.springboot.__user_management_system.exception.InvalidAgeException;
import com.springboot.__user_management_system.exception.UserNotFonudExceprion;
import com.springboot.__user_management_system.repository.UserRepository;

@Service
public class UserService {
	
	// inject user repository
	@Autowired
	private UserRepository userRepository; 

	// business logic
	public User saveUser(User user) {
		if(user.getAge()<18)
			throw new InvalidAgeException("Your age is less than 18");
		return userRepository.save(user);
	}
	
	// find user by id
	public ResponseUser findUser(long id) {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			User user = optional.get();
			ResponseUser responseUser = Mapper.map(user, ResponseUser.class);
			return responseUser;
		}
		throw new UserNotFonudExceprion("User with id "+id+" is Not Found");
	}
	
//	public User findUser(long id) {
//		Optional<User> optional = userRepository.findById(id);
//		if (optional.isPresent()) {
//			User User = optional.get();
//			User responseUser = new User();
//			responseUser.setAge(User.getAge());
//			responseUser.setName(User.getName());
//			responseUser.setEmail(User.getEmail());
//			return responseUser;
//		}
//		throw new UserNotFonudExceprion("User with id "+id+"id is not found");
//	}
//	
	// find user by id
//	public Users findUser(long id) {
//		Optional<Users> optional = userRepository.findById(id);
//		if (optional.isPresent())
//		return optional.get();
//		throw new UserNotFonudExceprion("User with id "+id+"id is not found");
//	}
	
	// find all users
	public List<User> findAllUser(){
		return userRepository.findAll();
	}
	
	// update user
//	public Users updateUser(long id, UserUpdate userUpdate) {
//		Users user = findUser(id);
//		user.setName(userUpdate.getName());
//		user.setAge(userUpdate.getAge());
//		user.setEmail(userUpdate.getEmail());
//		user.setPassword(userUpdate.getPassword());
//		
//	// save the updated user
//		return userRepository.save(user);
//	}
	
	
	// update user
	public User updateUser(long id, UserUpdate userUpdate) {
		ResponseUser user = findUser(id);
		user.setName(userUpdate.name());
		user.setAge(userUpdate.age());
		user.setEmail(userUpdate.email());
		user.setPassword(userUpdate.password());
		
		return userRepository.save(user);
	}
	

	  // delete user
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

}
