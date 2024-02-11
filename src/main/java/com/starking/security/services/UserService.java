package com.starking.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.starking.security.repositories.UserRepository;
import com.starking.security.user.User;

/**
 * @author pedroRhamon
 */

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public User create(User user) {
		User existUser = this.repository.findByUsername(user.getUsername());
		
		if(existUser != null) {
			throw new Error("User already exists!");
		}
		
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		User createUser = this.repository.save(user);
		
		return createUser;
	}
}
