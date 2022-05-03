package com.tnas.assignment.exceptionalpress;

public class CassetteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CassetteException() {
	}

	public CassetteException(String message) {
		super(message);
	}

	public CassetteException(Throwable cause) {
		super(cause);
	}

	public CassetteException(String message, Throwable cause) {
		super(message, cause);
	}

	public CassetteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
