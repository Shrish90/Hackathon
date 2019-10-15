package com.hackathon.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RepaymentDAOImpl {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void repayLoan() {
		String query = "update ";
	}
}
