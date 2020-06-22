package com.bojan.app.service;

import java.util.List;

import com.bojan.app.exception.ResourceNotFoundException;
import com.bojan.pojo.UserModel;


public interface UsersService {
	UserModel saveUser(UserModel user) throws ResourceNotFoundException;

	UserModel updateUser(Integer userId, UserModel user) throws ResourceNotFoundException;

	UserModel getUserById(Integer userId) throws ResourceNotFoundException;

	List<UserModel> getAllUsers();

	void deleteById(Integer userId);

	
}
