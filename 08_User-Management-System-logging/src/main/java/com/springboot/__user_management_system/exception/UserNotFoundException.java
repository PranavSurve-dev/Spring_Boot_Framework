package com.springboot.__user_management_system.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String massage) {
		super(massage);
	}
}
