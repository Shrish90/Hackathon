package com.hackathon.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/api")
@CrossOrigin("*")
public class LoanController {

private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

//	@Autowired
//	LoanService loanService;
//
///**
// * This method is used to collect Account details coming from UI
// * and verify for loan amount if eligible
// * @param Takes LoanApplication Object from UI
// * @return Map which holds information about status of application
// */
//
//@RequestMapping(value = "/loans", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//public ResponseEntity<Map<String,String>> Loans(@Valid @RequestBody LoanApplication loanApplicationObj) throws Exception{
//	
//	Map<String,String> result = new HashMap<>();
//	logger.info("****Loan Application*****"+ loanApplicationObj);
//	loanService.loanApplicationService(loanApplicationObj);
//	result.put("status", loanService.loanApplicationService(loanApplicationObj)+"");
//	return new ResponseEntity<>(result, HttpStatus.OK);
//}

}

