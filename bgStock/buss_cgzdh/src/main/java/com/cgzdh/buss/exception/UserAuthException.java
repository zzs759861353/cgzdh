package com.cgzdh.buss.exception;

import org.springframework.http.HttpStatus;

public class UserAuthException extends GlobalException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6134206672066469081L;

	public UserAuthException(String message) {
		super(message,  HttpStatus.FORBIDDEN);
	}
}
