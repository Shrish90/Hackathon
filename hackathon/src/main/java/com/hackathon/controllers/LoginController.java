package com.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exceptions.AuthException;
import com.hackathon.models.User;
import com.hackathon.service.LoginService;

/**
 * This controller handles login requests
 * @author kiranavk
 *
 */
@RestController
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	/**
	 * This validates user name and password and throws AuthException
	 * if a mismatch occurs.
	 * @param user
	 * @return
	 * @throws AuthException
	 */
	@PostMapping("/login")
	public String login(@RequestBody User user) throws AuthException {
		String loginResult = loginService.validateUser(user);				
		return loginResult;
	}
}
