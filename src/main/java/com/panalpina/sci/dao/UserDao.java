package com.panalpina.sci.dao;

import org.springframework.stereotype.Component;

import com.panalpina.sci.domain.User;
import com.panalpina.sci.exception.DAOException;

/**
 *
 * @author Cybage
 *
 */
@Component
public interface UserDao {

	/**
	 * Method to find the user by login username.
	 *
	 * @param username username
	 * @return User object
	 * @throws DAOException
	 */
	public User findUserByUserName(String username) throws DAOException;

	/**
	 * Method to get the user by user Id.
	 *
	 * @param userId User Id
	 * @return User object
	 * @throws DAOException
	 */
	public User findUserByUserId(String userId) throws DAOException;

	/**
	 * Method to save user information in database
	 *
	 * @param user
	 * @throws Exception
	 */

	public void saveUserDetails(User user) throws Exception;

}
