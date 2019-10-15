package com.hackathon.DAO.DAOImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hackathon.DAO.GetUserLoanDetailsDAO;

@Repository
public class GetUserLoanDetailsDAOImp implements GetUserLoanDetailsDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(GetUserLoanDetailsDAOImp.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	private final String get_userid_query = "SELECT * FROM userdetails where userid = ?";
	@Override
	public ResponseEntity<String> getUserLoanDetails(int userid) {
		
	jdbcTemplate.queryForList(get_userid_query, userid);
		return null;
	}
	

}
