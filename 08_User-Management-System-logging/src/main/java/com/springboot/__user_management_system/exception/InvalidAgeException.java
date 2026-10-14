 package com.springboot.__user_management_system.exception;

public class InvalidAgeException extends RuntimeException {

	public InvalidAgeException(String massage) {
		super(massage);
	}
}
