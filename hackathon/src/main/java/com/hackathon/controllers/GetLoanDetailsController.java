/**
 * 
 */
package com.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.service.GetLoanDetailsService;

/**
 * @author Vishal
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class GetLoanDetailsController {
	
	@Autowired
	GetLoanDetailsService getLoanDetailsService;
	@GetMapping("/get/{userid}")
	public  ResponseEntity<String> getUserLoanDetails(@PathVariable int userid) {
		
		getLoanDetailsService.getUserLoanDetails(userid);
		
	    return new ResponseEntity<String>("GET Response : "
	      + userid, HttpStatus.OK);
	}

}
