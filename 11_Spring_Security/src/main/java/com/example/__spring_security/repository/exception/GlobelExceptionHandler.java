package com.example.__spring_security.repository.exception;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionHandler {

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> handleAuthendicationException(AuthenticationException ex){
		String message = ex.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.UNAUTHORIZED);
	}
}
