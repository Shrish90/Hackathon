package com.hackathon.service;

import org.springframework.stereotype.Service;

import com.exceptions.AuthException;
import com.hackathon.models.User;

@Service
public class LoginService {
	public String validateUser(User user) throws AuthException {
		String username = user.getUserName();
		String password = user.getPassword();
		if(username == null || "".equals(username)) {
			throw new AuthException("Username should not be empty.");
		}
		if(password == null || "".equals(password)) {
			throw new AuthException("Password should not be empty.");
		}
		if(!"kiran".equalsIgnoreCase(username) || !"avk".equalsIgnoreCase(password)) {
			throw new AuthException("Username or Password is invalid.");
		}
		return "success";
	}
}
