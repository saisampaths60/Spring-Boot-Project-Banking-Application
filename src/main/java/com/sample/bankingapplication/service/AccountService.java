package com.sample.bankingapplication.service;

import java.util.Optional;

import com.sample.bankingapplication.entity.Account;

public interface AccountService {

	public Account createAccount(Account account);

	public Optional<Account> getAccount(Long id);

	public Account deposit(Long id, double amount);

	public Account withdraw(Long id, double amount);

}
