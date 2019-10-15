package com.hackathon.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hackathon.dao.LoginDAO;
import com.hackathon.models.UserRequest;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String validateLogin(UserRequest user) {
		String query = "select userid from userdetails where username = '"+user.getUserName() + "' and password = '"+user.getPassword()+"'";
		Long id = jdbcTemplate.queryForObject(query, Long.class);
		return id == null ? "" : id+"";
	}

}
