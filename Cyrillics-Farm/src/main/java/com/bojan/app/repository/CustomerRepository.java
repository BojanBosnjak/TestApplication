package com.bojan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bojan.app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByName(String name);

}
