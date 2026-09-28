package com.springboot.__web_services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/hello")
	
	public String sayHello() {
		return "Hello Everyone!!!!";
	}

}
