package com.hackathon.service;

import org.springframework.http.ResponseEntity;

public interface GetLoanDetailsService {

	ResponseEntity<String> getUserLoanDetails(int userid);
}
