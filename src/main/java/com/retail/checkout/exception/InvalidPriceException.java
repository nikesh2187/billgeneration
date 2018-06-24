package com.retail.checkout.exception;

public class InvalidPriceException extends CustomException {
	
private static final long serialVersionUID = 1L;
	
	public InvalidPriceException(String msg) {
		super(msg);
	}

	public InvalidPriceException(String msg, int errorId) {
		super(msg, errorId);
	}

}
