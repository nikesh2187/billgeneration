package com.retail.checkout.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	private int errorId; 

	public CustomException(String msg) {
		super(msg);
		this.errorId = HttpStatus.BAD_REQUEST.value();
	}

	public CustomException(String msg, int errorId) {
		super(msg);
		this.errorId = errorId;
	}

	public CustomException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	public int getErrorId() {
		return errorId;
	}
}
