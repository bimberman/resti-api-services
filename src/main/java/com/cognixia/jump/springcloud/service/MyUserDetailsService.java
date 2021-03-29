package com.cognixia.jump.springcloud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cognixia.jump.springcloud.model.User;
import com.cognixia.jump.springcloud.service.MyUserDetails;
import com.cognixia.jump.springcloud.repository.UserRepository;

public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = repo.findByUsername(username);
		
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("The username " + username + " was not found in our records!");
		}
		return new MyUserDetails(user.get());
	}

}
