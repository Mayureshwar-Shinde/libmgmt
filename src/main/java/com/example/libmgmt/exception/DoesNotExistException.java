package com.example.libmgmt.exception;

public class DoesNotExistException extends RuntimeException {
	
	public DoesNotExistException(String message) {
		super(message);
	}
}
