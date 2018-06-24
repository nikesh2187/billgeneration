package com.retail.checkout.exception;

public class ProductNotExistsException extends CustomException {

	private static final long serialVersionUID = 1L;

	public ProductNotExistsException(String msg) {
		super(msg);
	}

	public ProductNotExistsException(String msg, int errorId) {
		super(msg, errorId);
	}

}
