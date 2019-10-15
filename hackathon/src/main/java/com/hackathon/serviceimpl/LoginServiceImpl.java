package com.hackathon.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.hackathon.daoimpl.UserDAOImpl;
import com.hackathon.exceptions.AuthException;
import com.hackathon.models.UserRequest;
import com.hackathon.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

//	@Autowired
//	public UserDAOImpl userDAOImpl;
	
	/**
	 * This method validates the user by verifying his username and password
	 * @param user
	 * @return String LoginResult
	 * @throws AuthException
	 */
	public String validateUser(UserRequest user) throws AuthException {
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
//		userDAOImpl.existsById(1);
		
		return "success";
	}
}
