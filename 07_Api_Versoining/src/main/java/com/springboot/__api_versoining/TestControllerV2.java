package com.springboot.__api_versoining;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/students")
public class TestControllerV2 {

	@GetMapping("/{id}")
	public StudentV2 getStudent(@PathVariable int id) {
	
		return new StudentV2 (id,"pranav","panya@gmil.com");
	}
}
