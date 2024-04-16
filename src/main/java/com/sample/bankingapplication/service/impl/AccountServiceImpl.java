package com.sample.bankingapplication.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.bankingapplication.constants.MessageConstants;
import com.sample.bankingapplication.entity.Account;
import com.sample.bankingapplication.repository.AccountRepository;
import com.sample.bankingapplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Optional<Account> getAccount(Long id) {
		return accountRepository.findById(id);
	}

	@Override
	public Account deposit(Long id, double amount) {
		Account account = getAccount(id).orElseThrow(() -> new RuntimeException(MessageConstants.ACCOUNT_NOT_FOUND));
		account.setBalance(account.getBalance() + amount);
		return accountRepository.save(account);
	}

	@Override
	public Account withdraw(Long id, double amount) {
		Account account = getAccount(id).orElseThrow(() -> new RuntimeException(MessageConstants.ACCOUNT_NOT_FOUND));
		if (account.getBalance() < amount) {
			throw new RuntimeException(MessageConstants.INSUFFICIENT_FUNDS);
		}
		account.setBalance(account.getBalance() - amount);
		return accountRepository.save(account);
	}

}
