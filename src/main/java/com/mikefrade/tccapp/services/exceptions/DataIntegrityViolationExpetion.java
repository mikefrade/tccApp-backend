package com.mikefrade.tccapp.services.exceptions;

public class DataIntegrityViolationExpetion extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityViolationExpetion (String msg) {
		super(msg);
	}
	
	public DataIntegrityViolationExpetion (String msg, Throwable cause) {
		super(msg, cause);
	}

}
