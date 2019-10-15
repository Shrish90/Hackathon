package com.hackathon.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hackathon.dao.LoginDAO;
import com.hackathon.models.UserRequest;

public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String validateLogin(UserRequest user) {
		String query = "select id from userdetails where username = "+user.getUserName() + " and password = "+user.getPassword();
		Long id = jdbcTemplate.queryForObject(query, Long.class);
		return id == null ? "" : id+"";
	}

}
