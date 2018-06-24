package com.retail.checkout.exception;

public class InvalidCurrencyException extends CustomException {

	private static final long serialVersionUID = 1L;

	public InvalidCurrencyException(String msg) {
		super(msg);
	}

	public InvalidCurrencyException(String msg, int errorId) {
		super(msg, errorId);
	}

}
