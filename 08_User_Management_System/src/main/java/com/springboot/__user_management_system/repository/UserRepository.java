package com.springboot.__user_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.__user_management_system.entity.Users;

public interface UserRepository extends JpaRepository<Users,Long > {

	
}
