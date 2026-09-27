package com.springboot.__Save_Entity_Data_Base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.__Save_Entity_Data_Base.entity.Student;
import com.springboot.__Save_Entity_Data_Base.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	StudentRepository repository;
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		repository.save(student);
		return "success";
	}
}
