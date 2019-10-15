package com.exceptions;

public class AuthException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	
	public AuthException(String message) {
		errorMessage = message;
	}
}
