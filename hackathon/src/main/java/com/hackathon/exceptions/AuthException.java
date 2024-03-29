package com.hackathon.exceptions;

/**
 * This is the exception that is thrown when login fails.
 * @author kiranavk
 *
 */
public class AuthException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public AuthException(String errorMessage) {
		super(errorMessage);
	}
}
