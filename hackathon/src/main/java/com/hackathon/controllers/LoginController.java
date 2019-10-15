package com.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.exceptions.AuthException;
import com.hackathon.models.UserRequest;
import com.hackathon.service.LoginService;

/**
 * This controller handles login requests
 * @author kiranavk
 *
 */
@RestController
@CrossOrigin(origins = {"http://52.66.211.71:4200", "http://localhost:4200"})
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@GetMapping("/")
	public String home() {
		return "Hello Avengers!!!";
	}
	
	/**
	 * This validates user name and password and throws AuthException
	 * if a mismatch occurs.
	 * @param user
	 * @return
	 * @throws AuthException
	 */
	@PostMapping("/login")
	public String login(@RequestBody UserRequest user) throws AuthException {
		String loginResult = loginService.validateUser(user);				
		return loginResult;
	}
}
