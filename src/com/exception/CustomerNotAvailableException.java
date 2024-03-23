package com.exception;

public class CustomerNotAvailableException extends Exception{
	private static final long serialVersionUID = 1L;
    private String message;
    public CustomerNotAvailableException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
