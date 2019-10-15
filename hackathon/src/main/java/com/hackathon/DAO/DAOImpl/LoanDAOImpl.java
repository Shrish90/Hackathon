package com.hackathon.DAO.DAOImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.hackathon.DAO.LoanDAO;
import com.hackathon.model.LoanApplication;

@Repository
public class LoanDAOImpl implements LoanDAO{
	private static final Logger logger = LoggerFactory.getLogger(LoanDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	private final String loan_persist_query = "INSERT INTO loandetails(loantype, amount, rate, cid, userid) VALUES (?,?,?,?,?)";
	
	private final String get_userid_query = "SELECT userid FROM userdetails where passport = ?";
	@Override
	public boolean persistLoan(LoanApplication loanApplication) {
		jdbcTemplate.update(loan_persist_query,"C", loanApplication.getLoanDetails().getAmount(), 13,12,23);
		logger.info("ROW INSERTED");
		return true;
	}
	
	public int getUserIdByPassport(String passport) {
		jdbcTemplate.queryForList(get_userid_query, passport);
		return 0;
	}
}
	