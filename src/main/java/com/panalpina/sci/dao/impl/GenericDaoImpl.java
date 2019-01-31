package com.panalpina.sci.dao.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.panalpina.sci.dao.GenericDao;
import com.panalpina.sci.exception.DAOException;

/**
 * Implementation class for GenericDao
 * 
 * @author Cybage
 *
 */

@Repository
@Transactional
public class GenericDaoImpl implements GenericDao {

	private static final Logger logger = LogManager.getLogger(GenericDaoImpl.class);

	@PersistenceContext
	protected EntityManager entityManager;

	public <T> List<T> getPaginatedList(int pageNumber, int pagesize, List<T> list) {

		List<T> listOfObject = new ArrayList<T>(0);

		if (list != null && !list.isEmpty()) {

			int startIndx = 0;
			int endindx = 0;

			if (pageNumber > 1) {
				startIndx = (pageNumber - 1) * pagesize;
				endindx = (pagesize * pageNumber) - 1;
			} else {
				startIndx = pageNumber - 1;
				endindx = pagesize - 1;

			}
			if (list.size() <= endindx) {
				endindx = list.size() - 1;
			}
			for (int i = startIndx; i <= endindx; i++) {
				listOfObject.add(list.get(i));
			}
		}
		return listOfObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> queryForList(String queryString, Map<String, Object> parameters) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked queryForList method, queryString:" + queryString + ", parameters:" + parameters);
		}
		Query query = null;
		try {
			query = this.entityManager.createQuery(queryString);
			if (parameters != null) {
				for (Map.Entry<String, Object> entry : parameters.entrySet()) {
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}

		} catch (Exception e) {
			logger.error("Exception occured in queryForList method");
			throw new DAOException(e.getMessage());
		}

		return (List<T>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T queryForItem(String queryString, Map<String, Object> parameters) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked queryForItem method");
		}
		Query query = null;
		try {
			query = this.entityManager.createQuery(queryString);
			if (parameters != null) {
				for (Map.Entry<String, Object> entry : parameters.entrySet()) {
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}

		} catch (Exception e) {
			logger.error("Exception occured in queryForItem method");
			throw new DAOException(e.getMessage());
		}
		List<T> l = (List<T>) query.getResultList();

		T t = null;
		if (!l.isEmpty()) {
			t = l.get(0);
		}
		return t;
	}

	@Override
	public int executeQuery(String queryString, Map<String, Object> parameters) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked executeQuery method");
		}
		Query query = null;
		try {
			query = this.entityManager.createQuery(queryString);
			if (parameters != null) {
				for (Map.Entry<String, Object> entry : parameters.entrySet()) {
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}

		} catch (Exception e) {
			logger.error("Exception occured in executeQuery method");
			throw new DAOException(e.getMessage());
		}
		int i = query.executeUpdate();
		return i;
	}

	@Override
	public <T> int deleteRecord(Class<T> t, int id) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked deleteRecord method for Id:" + id + " classType:" + t);
		}
		Query query = null;
		String queryString = "delete from " + t.getSimpleName() + " a where a.id=:id ";
		try {
			query = this.entityManager.createQuery(queryString);
			query.setParameter("id", id);

		} catch (Exception e) {
			logger.error("Exception occured in deleteRecord method");
			throw new DAOException(e.getMessage());
		}
		int i = query.executeUpdate();
		return i;
	}

	public void clear() {
		this.entityManager.clear();
	}

	@Override
	public <T> T getBaseObject(Integer Id, Class<T> classType) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked getBaseObject method for Id:" + Id + " classType:" + classType);
		}
		T obj = null;
		if (Id != null) {
			obj = entityManager.find(classType, Id);
			if (obj == null)
				return null;
			if (!classType.isAssignableFrom(obj.getClass())) {
				return null;
			}
		}
		return obj;
	}

	@Override
	public <T> T getObject(Integer id, Class<T> classType) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked getObject method for Id:" + id + " classType:" + classType);
		}
		try {
			T obj = getBaseObject(id, classType);
			if (obj != null) {
				initializeObject(obj, classType);
			}
			return obj;
		} catch (Exception e) {
			logger.error("Exception in getObject method, Failed to load Id:" + id + "of type " + classType.toString()
					+ " Exception:" + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public <T> T insert(T obj) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked saveObject method obj:" + obj);
		}
		entityManager.persist(obj);
		return obj;
	}

	@Override
	public <T> void remove(T obj) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked removeObject method obj:" + obj);
		}
		if (obj != null) {
			obj = update(obj);
			entityManager.remove(obj);
		}
	}

	@Override
	public <T> T update(T obj) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked upsertObject method obj:" + obj);
		}
		if (!entityManager.contains(obj)) {
			obj = entityManager.merge(obj);
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getNamedQueryResult(String queryName, Map<String, String> params) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked getNamedQueryResult method queryName:" + queryName);
		}
		Query query = entityManager.createNamedQuery(queryName);
		if ((params != null) && (!params.isEmpty())) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getNamedQueryResult(String queryName, String param, String val) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("entering [getNamedQueryResult] for single parameter <" + param + "> queryName:" + queryName);
		}
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(param, val);
		return query.getResultList();
	}

	public <T> List<String> initializeObject(T obj, Class<T> classType) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked initializeObject method obj:" + obj + " classType" + classType);
		}
		Field[] fields = classType.getDeclaredFields();
		List<String> retval = new ArrayList<String>();
		for (Field field : fields) {
			Annotation annotation = field.getAnnotation(OneToMany.class);

			if ((annotation instanceof OneToMany)) {
				OneToMany myAnnotation = (OneToMany) annotation;
				logger.debug("name" + myAnnotation.fetch().name());
				boolean islazy = FetchType.LAZY.toString().equalsIgnoreCase(myAnnotation.fetch().name());
				if (islazy) {
					// Util.callGetter(field, obj);
					retval.add(field.getName());
				}
			}
		}
		return retval;
	}

	@Override
	public String getNativeQueryResultNoClass(String queryName, Map<String, String> params) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked getNativeQueryResultNoClass method queryName:" + queryName);
		}
		Query query = entityManager.createNativeQuery(queryName);
		if ((params != null) && (!params.isEmpty())) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.getSingleResult().toString();
	}

	@Override
	public String getNativeQueryResultNoClass(String queryName, List<String> params) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked getNativeQueryResultNoClass method queryName:" + queryName);
		}
		Query query = entityManager.createNativeQuery(queryName);
		if ((params != null) && (!params.isEmpty())) {
			for (int i = 1; i <= params.size(); i++) {
				query.setParameter(i, params.get(i - 1));
			}
		}
		return query.getSingleResult().toString();
	}

	@Override
	public Query createQuery(String queryString) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked createQuery method queryString:" + queryString);
		}
		return entityManager.createQuery(queryString);
	}

	@Override
	public Query createNativeQuery(String queryString) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked createNativeQuery method queryString:" + queryString);
		}
		return entityManager.createNativeQuery(queryString);
	}

	@Override
	public <T> Query createNativeQueryWithClass(String queryString, Class<T> classType) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked createNativeQuery method queryString:" + queryString);
		}
		return entityManager.createNativeQuery(queryString, classType);
	}

	@Override
	public String getUserName() throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked getUserId method");
		}
		/*
		 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 * String userName = auth.getName(); return userName;
		 */

		return null;
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked getCriteriaBuilder method");
		}
		return entityManager.getCriteriaBuilder();
	}

	@Override
	public <T> void flush() throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked flush method");
		}
		entityManager.flush();
	}

	@Override
	public Query createNamedQuery(String queryString) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked createNamedQuery method, queryString:" + queryString);
		}
		return entityManager.createNamedQuery(queryString);
	}

	@Override
	public Session getSession() throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked getSession method");
		}
		Session session = entityManager.unwrap(Session.class);

		return session;
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(String spName) throws DAOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Invoked createStoredProcedureQuery method queryString:" + spName);
		}
		return entityManager.createStoredProcedureQuery(spName);
	}

}
