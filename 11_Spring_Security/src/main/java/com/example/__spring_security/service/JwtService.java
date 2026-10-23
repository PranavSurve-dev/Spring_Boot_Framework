package com.example.__spring_security.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class JwtService {

	public JwtService(@Value("$jwt.secret)") String key) {
		
		
		
	}
}
