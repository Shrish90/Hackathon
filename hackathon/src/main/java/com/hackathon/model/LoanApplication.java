package com.hackathon.model;

/**
* <h1>Loan Application Modal </h1>
* This is the Modal Class for Loan Application
*
* @author  Shrish Tiwari
* @version 1.0
* @since   2019-10-15
*/
public class LoanApplication {

	private LoanDetails loanDetails;
	private CorporateDetails corporateDetails;
	private User userDetails;
	
	public LoanDetails getLoanDetails() {
		return loanDetails;
	}
	public void setLoanDetails(LoanDetails loanDetails) {
		this.loanDetails = loanDetails;
	}
	public CorporateDetails getCorporateDetails() {
		return corporateDetails;
	}
	public void setCorporateDetails(CorporateDetails corporateDetails) {
		this.corporateDetails = corporateDetails;
	}
	public User getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	
	
}
