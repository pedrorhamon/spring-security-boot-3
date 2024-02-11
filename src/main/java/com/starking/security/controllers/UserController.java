package com.starking.security.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starking.security.services.UserService;
import com.starking.security.user.User;

import lombok.RequiredArgsConstructor;

/**
 * @author pedroRhamon
 */
@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
public class UserController {

	private final UserService service;
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.service.create(user);
	}
}
