package com.infosys.exception;

public class ResourceNotFoundException extends RuntimeException{

	
	
	public ResourceNotFoundException() {
		super("Resouce Not found on server");
	}

	public ResourceNotFoundException(String message) {
		super(message);
		
	}

	
}
