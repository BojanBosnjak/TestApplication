package com.bojan.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bojan.app.entity.Account;
import com.bojan.app.repository.AccountRepository;
import com.bojan.pojo.AccountModel;

@Service
public class AccountServiceImplementation implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<AccountModel> getUserAccounts(Integer userId) {
		List<Account> entities = accountRepository.getUserAccounts(userId);

		List<AccountModel> result = new ArrayList<>();
		for (Account account : entities) {
			result.add(toModel(account));
		}
		return result;
	}
	
	@Override
	public void deleteById(Integer accId) {
		accountRepository.deleteById(accId);
	}


	private AccountModel toModel(Account entity) {
		AccountModel acc = new AccountModel();
		acc.setAccountId(entity.getAccountId());
		acc.setAccountName(entity.getAccountName());
		return acc;

	}

}
