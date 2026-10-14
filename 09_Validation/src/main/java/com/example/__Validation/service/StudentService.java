package com.example.__Validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.__Validation.entity.Student;
import com.example.__Validation.exception.MethodArgumentNotValidException;
import com.example.__Validation.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudents(Student student) {
		return studentRepository.save(student);
	}
	
	public Student saveStudent(Student student) {
		if(student.getAge()<18)
			throw new MethodArgumentNotValidException("Your age is less than 18");
		return studentRepository.save(student);
	}
}