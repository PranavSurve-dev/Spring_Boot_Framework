package com.springboot.__user_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionHandler {


	@ExceptionHandler(InvalidAgeException.class)
	public ResponseEntity<String> handleInvalidAgeException(InvalidAgeException ex){
		return new ResponseEntity <String> (ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFonudExceprion.class)
	public ResponseEntity<String> handleUserNotFonudExceprion(UserNotFonudExceprion ex){
		return new ResponseEntity <String> (ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
}
