package com.hackathon.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.model.LoanApplication;

/**
* <h1>Apply Loan Controller </h1>
* This is the Controller to take the loan details from UI
* and send the status back as success or failure
*
* @author  Shrish Tiwari
* @version 1.0
* @since   2019-10-15
*/
@RestController
@RequestMapping("/Loan")
@CrossOrigin("*")
public class LoanController {

private static final Logger logger = LoggerFactory.getLogger(LoanController.class);


/**
 * This method is used to collect Account details coming from UI
 * and verify for loan amount if eligible
 * @param Takes LoanApplication Object from UI
 * @return Map which holds information about status of application
 */

@RequestMapping(value = "/", method = RequestMethod.POST)
public ResponseEntity<Map<String,String>> ApplyLoan(@Valid @RequestBody LoanApplication loanApplicationObj){
	Map<String,String> result = new HashMap<>();
	logger.info("****RUNNING*****");
	result.put("root", "working fine");
	return new ResponseEntity<>(result, HttpStatus.OK);
}

}

