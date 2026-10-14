package com.springboot.__user_management_system.dto;

import lombok.Data;

@Data
public class ResponseUser {
	private String name;
	private int age;
	private String email;
}