package com.hackathon.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hackathon.DAO.GetUserLoanDetailsDAO;
import com.hackathon.service.GetLoanDetailsService;

@Service
public class GetLoanDetailsServiceImp implements GetLoanDetailsService {
	
  @Autowired
  GetUserLoanDetailsDAO getUserLoan;
	@Override
	public ResponseEntity<String> getUserLoanDetails(int userid) {
		
		ResponseEntity<String> res=new ResponseEntity<String>("Sucess", HttpStatus.OK);
		getUserLoan.getUserLoanDetails(userid);
		return res;
	}

}
