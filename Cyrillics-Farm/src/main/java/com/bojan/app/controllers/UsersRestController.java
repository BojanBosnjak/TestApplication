package com.bojan.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bojan.app.service.UsersService;
import com.bojan.pojo.UserModel;

import javassist.NotFoundException;

@RestController
@RequestMapping("/users")
public class UsersRestController {
	@Autowired
	private UsersService usersService;

	@GetMapping("/list")
	public List<UserModel> getAllUsers() {
		return usersService.getAllUsers();
	}

	@GetMapping("/{userId}")
	public UserModel getUserById(@PathVariable("userId") Integer userId) throws NotFoundException {

		return usersService.getUserById(userId);
	}

	@PostMapping("/create")
	public UserModel createUser(@Valid @RequestBody UserModel user) throws NotFoundException {
		return usersService.saveUser(user);
	}

	@PutMapping("/{userId}")
	public UserModel updateUser(@PathVariable Integer userId, @Valid @RequestBody UserModel userRequest)
			throws NotFoundException {
		return usersService.updateUser(userId, userRequest);
	}

	@DeleteMapping("/{userId}")
	public void deleteById(@PathVariable Integer userId) {
		usersService.deleteById(userId);
	}

}
