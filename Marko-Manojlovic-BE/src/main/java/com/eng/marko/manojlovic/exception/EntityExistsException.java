package com.eng.marko.manojlovic.exception;

public class EntityExistsException extends MyException {
	private static final long serialVersionUID = 7591495023608621668L;
	
	private final Object entity;

	public EntityExistsException(Object entity, String message) {
		super(message);
		this.entity = entity;
	}

	public Object getEntity() {
		return entity;
	}
}
