package com.bojan.app.service;

import java.util.List;

import com.bojan.pojo.AccountModel;

public interface AccountService {

	List<AccountModel> getUserAccounts(Integer userId);
	void deleteById(Integer accId);
}
