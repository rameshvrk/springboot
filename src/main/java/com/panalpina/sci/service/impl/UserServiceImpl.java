package com.panalpina.sci.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panalpina.sci.dao.GenericDao;
import com.panalpina.sci.domain.User;
import com.panalpina.sci.dto.MasterData;
import com.panalpina.sci.dto.UserDTO;
import com.panalpina.sci.exception.DAOException;
import com.panalpina.sci.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private GenericDao genericDao;

	@Override
	public void saveUserDetails(String name) throws DAOException {
		Random rand = new Random();
		int rand_int = rand.nextInt(1000);
		User user = new User(String.valueOf(rand_int), name);

		genericDao.insert(user);

	}

	@Override
	public List<User> getAllUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUserDetails() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasterData getMasterData() {
		// TODO Auto-generated method stub
		return null;
	}
}
