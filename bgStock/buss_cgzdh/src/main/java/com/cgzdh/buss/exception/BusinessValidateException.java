package com.cgzdh.buss.exception;

public class BusinessValidateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4221333501542774715L;
	
	public BusinessValidateException(){
		super();
	}
	
	public BusinessValidateException(String message){
		super(message);
	}
	
	public BusinessValidateException(String message,Throwable cause){
		super(message, cause);
	}

}
