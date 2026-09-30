package com.springboot.__reading_data_from_request;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	//1.Using PathVariable
@PostMapping("/path/{id}")
public String pathVariable(@PathVariable int id) {
		return "ID : "+id;
}
	//2.Using PathVariable with multiple parameters
	@PostMapping("/path/{id}/{name}")
	public String pathVariable(
		@PathVariable (value = "id") int stuId,
				@PathVariable String name){
		return "ID : "+ stuId +" Name :"+ name;
	}
		
	//3.Using RequestParam
		@PostMapping("/sample")
		public String queryString(
		@RequestParam (value = "id")int stuId,
	     @RequestParam String name){
		return "ID : "+stuId+" Name :"+ name;
				
	} 
		//4.Using RequestHeader
		@PostMapping("/test")
		public String requestHeader(@RequestHeader("Authorization") String token) {
			return token;//EX:- Bearer abc123
		}
		
		//5
		@PostMapping("/test1")
		public Student requestBody(@RequestBody Student student ) {
			return student;
		}
		//6
		@PostMapping("/test2")
		public String cookieValue(@CookieValue (value = "username")String username) {
	
			return username;	
		}
        //7
		@PostMapping("/test3")
		public String readRequest(RequestEntity<Student>req) {
			System.out.println(req.getUrl());
			System.out.println(req.getMethod());
			System.out.println(req.getHeaders().getFirst("Authorization"));
			System.out.println(req.getHeaders().getFirst("Content-Type"));
			System.out.println(req.getHeaders().getFirst("Cookie"));
			System.out.println(req.getBody());
			return "success";
		}
		
}
