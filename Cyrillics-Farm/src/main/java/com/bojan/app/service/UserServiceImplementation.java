package com.bojan.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.bojan.app.entity.User;
import com.bojan.app.exception.ResourceNotFoundException;
import com.bojan.app.repository.UsersRepository;
import com.bojan.pojo.UserModel;

@Service
public class UserServiceImplementation implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private PasswordEncoder encoder;
	@Override
	public UserModel saveUser(UserModel user) throws ResourceNotFoundException {

		User userEntity = new User();
		userEntity.setUserName(user.getUserName());
		String pass = encoder.encode(user.getPassword());
		userEntity.setPassword(pass);
		usersRepository.save(userEntity);
		return toModel(userEntity);
	}

	@Override
	public UserModel updateUser(Integer userId, UserModel user) throws ResourceNotFoundException {
		Optional<User> theUser = usersRepository.findById(userId);
		if (theUser.isEmpty()) {
			throw new ResourceNotFoundException("User not found");
		}
		User userEntity = theUser.get();
		userEntity.setUserName(user.getUserName());
		String pass = encoder.encode(user.getPassword());
		userEntity.setPassword(pass);
		usersRepository.save(userEntity);
		return toModel(userEntity);
	}

	@Override
	public List<UserModel> getAllUsers() {
		List<User> entities = usersRepository.findAll();

		List<UserModel> result = new ArrayList<>();
		for (User user : entities) {
			result.add(toModel(user));
		}
		return result;

	}

	@Override
	public UserModel getUserById(Integer userId) throws ResourceNotFoundException {
		Optional<User> optionalUser = usersRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new ResourceNotFoundException("User not found");
		}
		return toModel(optionalUser.get());

	}

	@Override
	public void deleteById(Integer userId) {

		usersRepository.deleteById(userId);
	}

	private UserModel toModel(User entity) {
		UserModel userModel = new UserModel();
		userModel.setId(entity.getUserId());
		userModel.setUserName(entity.getUserName());
		userModel.setPassword(entity.getPassword());

		return userModel;
	}

}
