package com.example.__spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/register")
	public String openRegister() {
			return "Register page";
	}
	
	@GetMapping("/home")
	public String openHome() {
			return "Home page";
	}
	
	@GetMapping("/cart")
	public String openCart() {
			return "Cart page";
	}
}