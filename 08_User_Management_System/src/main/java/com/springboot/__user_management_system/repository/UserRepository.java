package com.springboot.__user_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.__user_management_system.dto.ResponseUser;
import com.springboot.__user_management_system.entity.User;

public interface UserRepository extends JpaRepository<User,Long > {

	User save(ResponseUser user);

	
}
