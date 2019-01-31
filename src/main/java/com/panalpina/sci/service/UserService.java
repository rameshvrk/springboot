package com.panalpina.sci.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.panalpina.sci.domain.User;
import com.panalpina.sci.dto.MasterData;
import com.panalpina.sci.dto.UserDTO;
import com.panalpina.sci.exception.DAOException;

@Component
public interface UserService {

	public void saveUserDetails(String name) throws DAOException;

	public List<User> getAllUserDetails();

	public UserDTO getUserDetails() throws Exception;

	public MasterData getMasterData();
}
