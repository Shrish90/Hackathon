package com.hackathon.dao;

import com.hackathon.models.UserRequest;

public interface LoginDAO {
	public String validateLogin(UserRequest user);
}
