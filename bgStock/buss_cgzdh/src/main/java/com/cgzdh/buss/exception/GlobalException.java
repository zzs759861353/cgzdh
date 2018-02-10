package com.cgzdh.buss.exception;

import org.springframework.http.HttpStatus;

public class GlobalException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8032804830915609109L;
	private HttpStatus status;
	private String message;
	public GlobalException(String message,HttpStatus status) {
		super(message);
		this.message=message;
		this.status=status;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "GlobalException [status=" + status + ", message=" + message + "]";
	}
	
	
}
