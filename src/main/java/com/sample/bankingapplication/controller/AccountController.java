package com.sample.bankingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.bankingapplication.constants.MessageConstants;
import com.sample.bankingapplication.dto.AmountDto;
import com.sample.bankingapplication.entity.Account;
import com.sample.bankingapplication.service.AccountService;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping
	public Account createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}

	@GetMapping("/{id}")
	public Account getAccount(@PathVariable Long id) {
		return accountService.getAccount(id)
				.orElseThrow(() -> new RuntimeException(MessageConstants.ACCOUNT_NOT_FOUND));
	}

	@PostMapping("/{id}/deposit")
	public Account deposit(@PathVariable Long id, @RequestBody AmountDto request) {
		Double amount = request.getAmount();
		return accountService.deposit(id, amount);
	}

	@PostMapping("/{id}/withdraw")
	public Account withdraw(@PathVariable Long id, @RequestBody AmountDto request) {
		Double amount = request.getAmount();
		return accountService.withdraw(id, amount);
	}

}
