package com.panalpina.sci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panalpina.sci.exception.DAOException;
import com.panalpina.sci.service.UserService;

/**
 * Rest Service for login
 * 
 * @author Cybage
 *
 */

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/userDetails/{username}")
	public void getAllUsers(@PathVariable("username") String username) throws DAOException {

		userService.saveUserDetails(username);

	}

}
