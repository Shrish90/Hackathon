package com.hackathon.DAO;

import com.hackathon.model.LoanApplication;

public interface LoanDAO {
	public boolean persistLoan(LoanApplication loanApplication);
}
