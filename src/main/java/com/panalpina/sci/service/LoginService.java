package com.panalpina.sci.service;

import org.springframework.stereotype.Component;

import com.panalpina.sci.domain.User;
import com.panalpina.sci.dto.LoginDTO;
import com.panalpina.sci.dto.Message;

@Component
public interface LoginService {

	/**
	 * Method to get validate the logged in user
	 *
	 * @param loginDTO loginDTO
	 * @return message either success or failed
	 */
	public Message validateUser(LoginDTO loginDTO);

	/**
	 * Method to get the user object by using username
	 *
	 * @param userName User Name
	 * @return User object
	 */
	public User getUserByUserName(String userName);
}
