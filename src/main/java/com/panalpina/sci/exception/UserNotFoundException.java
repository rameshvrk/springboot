package com.panalpina.sci.exception;

import com.panalpina.sci.constants.SciExceptionMessages;

/**
 * @author Cybage
 */
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super(SciExceptionMessages.NoUserExist.getMessage());
	}

	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
