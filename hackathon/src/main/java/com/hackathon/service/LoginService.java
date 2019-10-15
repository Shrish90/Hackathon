package com.hackathon.service;

import org.springframework.stereotype.Service;

import com.exceptions.AuthException;
import com.hackathon.models.User;

/**
 * This is the service responsible for login related services.
 * @author kiranavk
 *
 */
@Service
public class LoginService {
	
	/**
	 * This method validates the user by verifying his username and password
	 * @param user
	 * @return String LoginResult
	 * @throws AuthException
	 */
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
