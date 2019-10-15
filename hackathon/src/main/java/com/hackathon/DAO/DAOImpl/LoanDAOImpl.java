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

/**
* <h1>Loan DAO</h1>
* This is the DAO to take the loan details from Service
* and persist in db
* 
*
* @author  Shrish Tiwari
* @version 1.0
* @since   2019-10-15
*/


@Repository
public class LoanDAOImpl implements LoanDAO{
	private static final Logger logger = LoggerFactory.getLogger(LoanDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	private final String loan_persist_query = "INSERT INTO loandetails(loantype, amount, rate, cid, userid) VALUES (?,?,?,?,?)";
	private final String get_userid_query = "SELECT userid FROM userdetails where passport = ?";
	private final String get_companyid_query = "SELECT cid FROM companydetails where cregisterno = ?";
	private final String get_amount_by_cid = "SELECT l.amount FROM loandetails l,companydetails c where c.cid = l.cid and c.cregisterno = ?";
	private final String get_amount_by_userid = "SELECT l.amount FROM loandetails l,userdetails u where l.userid = u.userid and u.passport = ?";
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
		logger.info("getuserIdByPassport called" + passport);
		return Integer.parseInt(userId.get(0).get("userId")+"");
	}
	
	public int getCompanyIdByRegNo(String regNo) {
		List<Map<String,Object>> cId = jdbcTemplate.queryForList(get_companyid_query, regNo);
		logger.info("getCompanyIdByRegNo called" + regNo);
		return Integer.parseInt(cId.get(0).get("cid")+"");	
	}

	@Override
	public double getLoanAmountByRegNo(String regNo) {
		double result = 0.0;
		List<Map<String,Object>> amounts = jdbcTemplate.queryForList(get_amount_by_cid, regNo);
		for(Map<String,Object> amountObj:amounts) {
			result = result + Double.parseDouble(amountObj.get("amount")+"");
		}
		logger.info("total loan on company" + result);
		return result;
	}

	@Override
	public double getLoanAmountByPassport(String passport) {
		double result = 0.0;
		List<Map<String,Object>> amounts = jdbcTemplate.queryForList(get_amount_by_userid, passport);
		for(Map<String,Object> amountObj:amounts) {
			result = result + Double.parseDouble(amountObj.get("amount")+"");
		}
		logger.info("total loan on user" + result);
		return result;
	}
}
	