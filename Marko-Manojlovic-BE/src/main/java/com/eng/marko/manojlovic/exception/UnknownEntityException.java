package com.eng.marko.manojlovic.exception;

public class UnknownEntityException extends MyException {
	private static final long serialVersionUID = -364782738734681073L;
	
	private final Object entity;

	public UnknownEntityException(Object entity, String message) {
		super(message);
		this.entity = entity;
	}

	public Object getEntity() {
		return entity;
	}
}
