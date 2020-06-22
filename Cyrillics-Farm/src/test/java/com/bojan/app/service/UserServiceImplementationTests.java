package com.bojan.app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bojan.app.entity.User;
import com.bojan.app.exception.ResourceNotFoundException;
import com.bojan.app.repository.UsersRepository;
import com.bojan.pojo.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplementationTests {
	@Mock
	private UsersRepository mockRepository;
	@Mock
	private PasswordEncoder encoder;
	@InjectMocks
	private UserServiceImplementation service;

	@Test
	public void testSaveUser() throws ResourceNotFoundException {
		User user = new User();
		user.setPassword("Test password");
		user.setUserName("Test username");
		Mockito.when(mockRepository.save(Mockito.any())).thenReturn(user);	
		Mockito.when(encoder.encode(Mockito.any())).thenReturn("Test password");
		
		
		UserModel userModel = new UserModel();
		userModel.setPassword("Test password");
		userModel.setUserName("Test username");
		UserModel result = service.saveUser(userModel);

		Mockito.verify(mockRepository).save(Mockito.any());
		Assert.assertEquals("Test password", result.getPassword());
		Assert.assertEquals("Test username", result.getUserName());

	}

	@Test(expected = ResourceNotFoundException.class)
	public void testUpdateUserFails() throws ResourceNotFoundException {

		Mockito.when(mockRepository.findById(Mockito.any())).thenReturn(Optional.empty());

		UserModel userModel = new UserModel();
		userModel.setPassword("Test password");
		userModel.setUserName("Test username");
		service.updateUser(1, userModel);
	}

	@Test
	public void testUpdateUser() throws ResourceNotFoundException {

		User user = new User();
		user.setPassword("Test password");
		user.setUserName("Test username");

		Mockito.when(mockRepository.save(Mockito.any())).thenReturn(user);

		Mockito.when(mockRepository.findById(Mockito.any())).thenReturn(Optional.of(user));
		Mockito.when(encoder.encode(Mockito.any())).thenReturn("Test password");

		UserModel userModel = new UserModel();
		userModel.setPassword("Test password");
		userModel.setUserName("Test username");
		UserModel result = service.updateUser(1, userModel);

		Mockito.verify(mockRepository).save(Mockito.any());
		Assert.assertEquals("Test password", result.getPassword());
		Assert.assertEquals("Test username", result.getUserName());
	}

	@Test
	public void testGetUserById() throws ResourceNotFoundException {
		User user = new User();
		user.setPassword("Test password");
		user.setUserName("Test username");
		Mockito.when(mockRepository.findById(Mockito.any())).thenReturn(Optional.of(user));

		UserModel result = service.getUserById(1);

		Assert.assertEquals("Test password", result.getPassword());
		Assert.assertEquals("Test username", result.getUserName());

	}

	@Test
	public void testGetAll() {
		User user1 = new User();
		user1.setPassword("Test password");
		user1.setUserName("Test username");
		User user2 = new User();
		user2.setPassword("Test password2");
		user2.setUserName("Test username2");
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);

		Mockito.when(mockRepository.findAll()).thenReturn(users);

		List<UserModel> result = service.getAllUsers();
		Assert.assertEquals(2, result.size());
	}
}
