package com.hackathon.service;

import org.springframework.stereotype.Component;

import com.hackathon.exceptions.AuthException;
import com.hackathon.models.UserRequest;

/**
 * This is the service responsible for login related services.
 * @author kiranavk
 *
 */
@Component
public interface LoginService {
	
	/**
	 * This method validates the user by verifying his username and password
	 * @param user
	 * @return String LoginResult
	 * @throws AuthException
	 */
	public String validateUser(UserRequest user) throws AuthException;
}
