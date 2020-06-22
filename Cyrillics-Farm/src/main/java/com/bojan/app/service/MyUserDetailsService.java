package com.bojan.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bojan.app.entity.User;
import com.bojan.app.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = usersRepository.findByUserName(userName);
		
		user.orElseThrow(()-> new UsernameNotFoundException("Username not found: "+userName));
		
		return user.map(MyUserDetails::new).get();
	}

}
