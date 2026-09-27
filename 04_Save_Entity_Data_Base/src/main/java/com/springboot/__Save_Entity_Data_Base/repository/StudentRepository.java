package com.springboot.__Save_Entity_Data_Base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.__Save_Entity_Data_Base.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
