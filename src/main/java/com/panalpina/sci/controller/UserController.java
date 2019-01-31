package com.panalpina.sci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panalpina.sci.dto.MasterData;
import com.panalpina.sci.dto.UserDTO;
import com.panalpina.sci.exception.ServiceException;
import com.panalpina.sci.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/getUserDetails")
	public UserDTO getUserDetails() throws ServiceException {
		try {
			return userService.getUserDetails();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@GetMapping(value = "/getMasterData")
	public MasterData getMasterData() throws ServiceException {
		try {
			return userService.getMasterData();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
