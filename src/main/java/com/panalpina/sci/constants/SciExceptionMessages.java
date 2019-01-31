package com.panalpina.sci.constants;

/**
 * @author Cybage
 * 
 *UserRoles enumeration contains User role name defined in SCI system.
 */
public enum SciExceptionMessages {

	NoUserExist("User does not exist in system."), NoRolesAssigned("Role is not assigned to user."),;

	private String message;

	SciExceptionMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}