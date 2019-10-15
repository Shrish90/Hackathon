package com.hackathon.DAO;

import org.springframework.http.ResponseEntity;


public interface GetUserLoanDetailsDAO {
	
	public  ResponseEntity<String> getUserLoanDetails(int userid);

}
