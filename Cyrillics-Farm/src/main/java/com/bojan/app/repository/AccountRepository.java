package com.bojan.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bojan.app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findByAccountName(String name);
	
	@Query("select a from Account a where a.user.userId =:userId")
	List<Account> getUserAccounts(Integer userId);
}
