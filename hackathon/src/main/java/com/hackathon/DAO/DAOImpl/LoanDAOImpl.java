package com.hackathon.DAO.DAOImpl;

import java.util.List;
import java.util.Map;

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
	private final String get_companyid_query = "SELECT cid FROM companydetails where cregisterno = ?";
	private final int rateOfInterest = 13;
	@Override
	public boolean persistLoan(LoanApplication loanApplication) {
		jdbcTemplate.update(loan_persist_query,"C", loanApplication.getLoanDetails().getAmount()
				,rateOfInterest
				,getCompanyIdByRegNo(loanApplication.getCorporateDetails().getRegNo())
				,getUserIdByPassport(loanApplication.getUserDetails().getPassport()));
		logger.info("ROW INSERTED");
		return true;
	}
	
	public int getUserIdByPassport(String passport) {
		List<Map<String,Object>> userId = jdbcTemplate.queryForList(get_userid_query, passport);
		return Integer.parseInt(userId.get(0).get("userId")+"");
	}
	
	public int getCompanyIdByRegNo(String regNo) {
		List<Map<String,Object>> cId = jdbcTemplate.queryForList(get_companyid_query, regNo);
		return Integer.parseInt(cId.get(0).get("cid")+"");	
	}
}
	