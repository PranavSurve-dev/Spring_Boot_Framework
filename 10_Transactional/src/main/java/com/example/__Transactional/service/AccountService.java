package com.example.__Transactional.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.__Transactional.entity.Account;
import com.example.__Transactional.repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountrepository;
	
	public AccountService (AccountRepository accountRepository) {
		this.accountrepository= accountRepository;
	}
	
	public Account saveAccount (Account account) {
		return accountrepository.save(account);
	}

	@Transactional
	public String transfer (int fromId, int toId,double amount) {
		Account account1 = accountrepository.findById(fromId).get();
		Account account2 = accountrepository.findById(toId).get();
		
		account1.setBalance(account1.getBalance()-amount);
		accountrepository.save(account1);
		if(false) {
			throw new RuntimeException("Network Issue");
		}
		account2.setBalance(account2.getBalance()+amount);
		accountrepository.save(account2);
		
		return "Transaction Successful";
	}
	public Page<Account> readAccounts(Pageable pageable) {
		return accountrepository.findAll(pageable);
	}
}
