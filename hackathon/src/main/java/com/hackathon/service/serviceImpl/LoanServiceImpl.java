package com.hackathon.service.serviceImpl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.DAO.LoanDAO;
import com.hackathon.model.LoanApplication;
import com.hackathon.service.LoanService;

/**
* <h1>Loan Service</h1>
* This is the Service to take the loan details from Controller
* and implements the business logic
*
* @author  Shrish Tiwari
* @version 1.0
* @since   2019-10-15
*/

@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	LoanDAO loanDao;
	
	private static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);
	
	/**
	 * This method is used to collect Account details coming from Controller
	 * and verify for loan amount if eligible
	 * @param Takes LoanApplication Object from Controller
	 * @return boolean value to state a success or failure
	 */

	@Override
	public boolean loanApplicationService(LoanApplication loanApplication) {
		boolean isEligible = true;
		if(loanApplication.getCorporateDetails().getCompanyAge() <=2
				|| loanApplication.getCorporateDetails().getRevenue() <= 50000 
				|| getLoanAmountByRegNo(loanApplication.getCorporateDetails().getRegNo()) > 1500000
				|| getLoanAmountPassport(loanApplication.getUserDetails().getPassport()) > 1500000
				|| calculateAgeByDob(loanApplication.getUserDetails().getDateOfBirth()) <=18) {
			logger.info("Validation fails due to business logic error");
			isEligible = false;
		}
		if(isEligible) {
			loanDao.persistLoan(loanApplication);
		}else {
			
		}
		return isEligible;
	}
	
	public Double getLoanAmountByRegNo(String regNo) {
		
		return 1500.00;
	}
	
	public Double getLoanAmountPassport(String passport) {
			
			return 1500.00;
		}
	public int calculateAgeByDob(Date dob) {
		
		return 33;
	}
	
	public String persistLoanApplication() {
		
		return null;
	}
}
