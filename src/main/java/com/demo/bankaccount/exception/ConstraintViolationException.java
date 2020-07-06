package com.demo.bankaccount.exception;

public class ConstraintViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ConstraintViolationException(String exception) {
		super(exception);
	}
}