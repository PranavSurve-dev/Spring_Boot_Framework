package com.example.__Transactional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.__Transactional.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
