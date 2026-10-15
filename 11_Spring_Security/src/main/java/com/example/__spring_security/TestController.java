package com.example.__spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/register")
	public String openRegister() {
			return "Register page";
	}
}
