package com.panalpina.sci.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panalpina.sci.constants.CommonConstants;
import com.panalpina.sci.dao.UserDao;
import com.panalpina.sci.domain.User;
import com.panalpina.sci.dto.LoginDTO;
import com.panalpina.sci.dto.Message;
import com.panalpina.sci.exception.DAOException;
import com.panalpina.sci.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	final static Logger logger = LogManager.getLogger(LoginServiceImpl.class);

	@Autowired
	public UserDao userDao;

	@Override
	public Message validateUser(LoginDTO loginDTO) {

		System.out.println("*******Validating");
		if (logger.isDebugEnabled()) {
			logger.debug("Invoke validateUser method, params -> loginDTO:" + loginDTO);
		}

		Message message = null;

		if (loginDTO != null) {

			User user = getUserByUserName(loginDTO.getUsername());

			if (user != null && !CommonConstants.BLANK.equalsIgnoreCase(user.getUserName())
					&& !CommonConstants.BLANK.equalsIgnoreCase(user.getPassword())) {
				if ((loginDTO.getUsername()).equals(user.getUserName())
						&& (loginDTO.getPassword()).equals(user.getPassword())) {
					message = new Message("SUCCESS", "SUCCESS");
					logger.info("Login Successful");
				} else {
					message = new Message("FAIL",
							"OOPS!! Something went wrong looks USER NAME or PASSWORD is INCORRECT TRY Again..");
					logger.info("OOPS!! Something went wrong looks USER NAME or PASSWORD is INCORRECT TRY Again..");
				}
			} else {
				message = new Message("FAIL",
						"OOPS!! Something went wrong looks USER NAME or PASSWORD is INCORRECT TRY Again..");
				logger.info("OOPS!! Something went wrong looks USER NAME or PASSWORD is INCORRECT TRY Again..");
			}
		}
		return message;
	}

	@Override
	public User getUserByUserName(String userName) {
		try {
			return userDao.findUserByUserName(userName);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
