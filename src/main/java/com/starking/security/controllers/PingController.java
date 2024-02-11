package com.starking.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pedroRhamon
 */
@RestController
@RequestMapping(value = "ping")
public class PingController {
	
	@GetMapping
	public String ping() {  
		return "pong";
	}

}
