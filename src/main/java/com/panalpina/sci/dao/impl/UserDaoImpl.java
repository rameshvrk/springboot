package com.panalpina.sci.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panalpina.sci.dao.GenericDao;
import com.panalpina.sci.dao.UserDao;
import com.panalpina.sci.domain.User;
import com.panalpina.sci.exception.DAOException;

/**
 * @author Cybage
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	public GenericDao genericDao;

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByUserName(String username) throws DAOException {

		List<User> users = (List<User>) entityManager
				.createQuery("SELECT c FROM User c WHERE UPPER(c.username) = :username")
				.setParameter("username", username.toUpperCase()).getResultList();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByUserId(String userId) throws DAOException {
		List<User> users = (List<User>) entityManager.createQuery("SELECT c FROM User c WHERE c.id = :userId")
				.setParameter("userId", userId).getResultList();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void saveUserDetails(User user) throws Exception {
		genericDao.insert(user);
	}

}