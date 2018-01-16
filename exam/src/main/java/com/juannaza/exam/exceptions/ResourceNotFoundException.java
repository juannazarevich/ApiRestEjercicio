package com.juannaza.exam.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 7597379526772094472L;

	public ResourceNotFoundException(final String message) {
		super(message);
	}

	public ResourceNotFoundException(final String message, final Throwable e) {
		super(message, e);
	}
}
