package com.cgzdh.buss.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends GlobalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2927076813698042767L;

	public BusinessException(String message) {
		super(message,  HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
