package com.bojan.app.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bojan.app.entity.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}
