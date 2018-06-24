package com.retail.checkout.exception;

public class InvalidCategoryException extends CustomException {
	private static final long serialVersionUID = 1L;
	
	public InvalidCategoryException(String msg) {
		super(msg);
	}

	public InvalidCategoryException(String msg, int errorId) {
		super(msg, errorId);
	}

}
