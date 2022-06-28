package com.eng.marko.manojlovic.exception;

public class InvalidEntityException extends MyException {
	private static final long serialVersionUID = 7290876179774863259L;
	
	private final Object entity;

	public InvalidEntityException(Object entity, String message) {
		super(message);
		this.entity = entity;
	}
	
	public Object getEntity() {
		return entity;
	}
}
