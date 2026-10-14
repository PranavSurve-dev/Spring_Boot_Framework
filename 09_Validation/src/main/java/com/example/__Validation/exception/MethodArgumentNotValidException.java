package com.example.__Validation.exception;


public class MethodArgumentNotValidException extends RuntimeException {

	public MethodArgumentNotValidException(String massage) {
		super(massage);
	}
}
