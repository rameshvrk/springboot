package com.panalpina.sci.exception;

import com.panalpina.sci.constants.SciExceptionMessages;

public class RolesNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RolesNotFoundException() {

		super(SciExceptionMessages.NoRolesAssigned.getMessage());
	}
}
