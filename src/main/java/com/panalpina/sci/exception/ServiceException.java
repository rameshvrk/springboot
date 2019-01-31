package com.panalpina.sci.exception;

/**
 * ServiceException is an exception class which will throw all exceptions
 * occurred in service layer
 * 
 * @author Cybage
 *
 */
public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServiceException(String errorMessage) {
		super(errorMessage);
	}

	public ServiceException(Exception ex) {
		super(ex);
	}

	public ServiceException(Exception ex, String message) {
		super(message, ex);
	}
}
