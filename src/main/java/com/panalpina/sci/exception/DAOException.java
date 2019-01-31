package com.panalpina.sci.exception;

/**
 * DAOException will throw the DAO Layer Exceptions
 * 
 * @author Cybage
 *
 */
public class DAOException extends Exception {
	private static final long serialVersionUID = 1L;

	public DAOException(String errorMessage) {
		super(errorMessage);
	}

	public DAOException(String errorMessage, Exception e) {
		super(errorMessage, e);
	}
}
