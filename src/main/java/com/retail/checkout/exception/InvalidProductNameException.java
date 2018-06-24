package com.retail.checkout.exception;

public class InvalidProductNameException extends CustomException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidProductNameException(String msg) {
		super(msg);
	}

	public InvalidProductNameException(String msg, int errorId) {
		super(msg, errorId);
	}

}
