package com.proposta.contrato.exception;


public class ContratoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;

	public ContratoException(String message) {
		super(message);
		this.message = message;
	}
	
	public ContratoException() {
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
