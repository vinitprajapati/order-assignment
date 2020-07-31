package com.knowarth.api.order.item.exception;

public class InvalidOrderException extends RuntimeException {

	private static final long serialVersionUID = 8642471320480718864L;

	public InvalidOrderException(String exception) {
		super(exception);
	}

}
