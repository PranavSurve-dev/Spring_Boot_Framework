package com.springboot.__reading_data_from_request;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	//1
	
//	@PostMapping("/path/{id}")
//	public String pathVariable(@PathVariable int id) {
//		return "ID : "+id;
	
	//2
	@PostMapping("/path/{id}/{name}")
	public String pathVariable(
		@PathVariable (value = "id") int stuId,
				@PathVariable String name){
		return "ID : "+ stuId +" Name :"+ name;
	}
		
	//3
		@PostMapping("/sample")
		public String queryString(
		@RequestParam (value = "id")int stuId,
	     @RequestParam String name){
		return "ID : "+stuId+" Name :"+ name;
				
	} 

}
