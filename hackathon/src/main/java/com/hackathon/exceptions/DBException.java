package com.hackathon.exceptions;

public class DBException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DBException(String message) {
		super(message);
	}
}
