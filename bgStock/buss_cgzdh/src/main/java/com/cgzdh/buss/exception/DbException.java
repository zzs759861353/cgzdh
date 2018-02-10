package com.cgzdh.buss.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
public class DbException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter Integer code;
	@Getter @Setter String msg;

}
