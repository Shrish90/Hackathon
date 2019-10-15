package com.hackathon.application.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hackathon.exceptions.DBException;

@Service
public class LoanRepaymentScheduler {
	
	private Logger logger = LoggerFactory.getLogger(LoanRepaymentScheduler.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Scheduled(fixedRate = 2000)
	public void repayLoan() throws Exception {
	    logger.info("In Repay loan");
	    
	    try {
	    	Integer loanAmount = getLoanAmount();
		    logger.info("loan amount: "+loanAmount);
		    
		    if(loanAmount > 0) {
		    	jdbcTemplate.update("update loandetails set amount = amount - 10000 where loadid=1");
		    	loanAmount = getLoanAmount();
			    logger.info("loan amount: "+loanAmount);
		    } else {
		    	logger.info("Your loan amount is cleared!! Hurrey!!! No need to pay EMI again");
		    }
	    } catch(Exception e) {
	    	throw new DBException(e.getMessage());
	    }
	}
	
	public Integer getLoanAmount() {
		Integer loanAmount = jdbcTemplate.queryForObject("select amount from loandetails where loadid=1", Integer.class);
		return loanAmount;
	}
}
