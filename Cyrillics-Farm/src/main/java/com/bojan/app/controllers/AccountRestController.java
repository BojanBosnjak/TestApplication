package com.bojan.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bojan.app.service.AccountService;
import com.bojan.pojo.AccountModel;

@RestController
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts/user/{userId}")
	public List<AccountModel> getUserAccounts(@PathVariable ("userId") Integer userId){
		return accountService.getUserAccounts(userId);
		
	}
	
	@DeleteMapping("/accounts/{accId}")
	public void deleteById(@PathVariable Integer accId) {
		accountService.deleteById(accId);
	}
}
