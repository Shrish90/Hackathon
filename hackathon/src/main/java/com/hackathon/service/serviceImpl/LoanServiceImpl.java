package com.hackathon.service.serviceImpl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hackathon.model.LoanApplication;
import com.hackathon.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService{
	private static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

	@Override
	public String loanApplicationService(LoanApplication loanApplication) {
		boolean isEligible = true;
		if(loanApplication.getCorporateDetails().getCompanyAge() <=2
				|| loanApplication.getCorporateDetails().getRevenue() <= 50000 
				|| getLoanAmountByRegNo(loanApplication.getCorporateDetails().getRegNo()) > 1500000
				|| getLoanAmountPassport(loanApplication.getUserDetails().getPassport()) > 1500000
				|| calculateAgeByDob(loanApplication.getUserDetails().getDateOfBirth()) <=18) {
			
		}
		
		return null;
	}
	
	public Double getLoanAmountByRegNo(String regNo) {
		
		return null;
	}
	
	public Double getLoanAmountPassport(String passport) {
			
			return null;
		}
	public int calculateAgeByDob(Date dob) {
		return 0;
	}
	
}
