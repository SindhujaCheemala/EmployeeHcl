package com.hcl.employeedirectory.exception;

public class IdException extends Exception {

	private static final long serialVersionUID = 1L;

	private String msg;

	public IdException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
}
