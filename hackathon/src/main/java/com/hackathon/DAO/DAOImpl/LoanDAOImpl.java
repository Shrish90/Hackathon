package com.hackathon.DAO.DAOImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.hackathon.DAO.LoanDAO;

@Repository
public class LoanDAOImpl implements LoanDAO{
	private static final Logger logger = LoggerFactory.getLogger(LoanDAOImpl.class);
}
