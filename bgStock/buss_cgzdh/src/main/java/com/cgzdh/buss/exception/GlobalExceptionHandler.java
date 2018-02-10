package com.cgzdh.buss.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
@SuppressWarnings("unused")
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(GlobalException.class)
	@ResponseBody
	public ResponseEntity<?> handleBusinessException(HttpServletRequest request, HttpServletResponse response, GlobalException exception) {
		exception.printStackTrace();
		logger.error("BusinessException Occured:: #URL= "+request.getRequestURL()+" #CLASS= "+exception.getClass().getSimpleName()+" #Cause= "+exception.getMessage());
		logger.error(exception.toString(), exception);
//		return new ResponseEntity<>(new ErrorResponse("BUSINESS_ERROR", exception.getMessage()), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), exception.getStatus());
	}
	private class ErrorResponse {
		@Deprecated
		private String errorCode;
		private String errorMsg;
		
		public ErrorResponse() {
		}
		
		
		@Deprecated
		public ErrorResponse(String errorCode, String errorMsg) {
			this.errorCode = errorCode;
			this.errorMsg  = errorMsg;
		}
		
		public ErrorResponse(String errorMsg) {
			this.errorMsg  = errorMsg;
		}

		@Deprecated
		public String getErrorCode() {
			return errorCode;
		}

		@Deprecated
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

		public String getErrorMsg() {
			return errorMsg;
		}

		public void setErrorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
		}

	}
}
