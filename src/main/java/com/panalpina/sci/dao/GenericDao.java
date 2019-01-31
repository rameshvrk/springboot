package com.panalpina.sci.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;

import com.panalpina.sci.exception.DAOException;

/**
 * GenericDao interface
 * 
 * @author Cybage
 *
 */
public interface GenericDao {

	/**
	 * Method to get the paginated list
	 * 
	 * @param pageNumber current page number
	 * @param pagesize   total pagesize
	 * @param list       list of objects
	 * @return paginated list
	 */
	public <T> List<T> getPaginatedList(int pageNumber, int pagesize, List<T> list);

	/**
	 * Method to get the list type of query
	 * 
	 * @param queryString Query string
	 * @param parameters  parameters as input
	 * @return list of objects
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> List<T> queryForList(String queryString, Map<String, Object> parameters) throws DAOException;

	/**
	 * Method to get single result by querying
	 * 
	 * @param queryString Query String
	 * @param parameters  parameters
	 * @return
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> T queryForItem(String queryString, Map<String, Object> parameters) throws DAOException;

	/**
	 * Method to excute query with params. useful for delete or update operations
	 * 
	 * @param queryString Query String
	 * @param parameters  parameters
	 * @return int
	 * @throws DAOException Dao Layer Exceptions
	 */
	public int executeQuery(String queryString, Map<String, Object> parameters) throws DAOException;

	/**
	 * Method to delete the record from the database
	 * 
	 * @param t  classtype
	 * @param id primary key id
	 * @return int
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> int deleteRecord(Class<T> t, int id) throws DAOException;

	/**
	 * Method to get the base object(plain object)
	 * 
	 * @param Id        primary key id
	 * @param classType class type
	 * @return object
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> T getBaseObject(Integer Id, Class<T> classType) throws DAOException;

	/**
	 * Method to get the full detailed object. it will fetch all the lazy
	 * initializations associated with the entity
	 * 
	 * @param id        primary key id
	 * @param classType class type
	 * @return object
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> T getObject(Integer id, Class<T> classType) throws DAOException;

	/**
	 * Method to save the object into the database
	 * 
	 * @param obj Object
	 * @return updated object
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> T insert(T obj) throws DAOException;

	/**
	 * Method to remove the object from the database
	 * 
	 * @param obj object
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> void remove(T obj) throws DAOException;

	/**
	 * Method to Save or Update the object with updated data
	 * 
	 * @param obj object
	 * @return updated object
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> T update(T obj) throws DAOException;

	/**
	 * Method to get the named query result
	 * 
	 * @param queryName query name
	 * @param params    input params
	 * @return list of object
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> List<T> getNamedQueryResult(String queryName, Map<String, String> params) throws DAOException;

	/**
	 * Method to get the named query result with single param\value
	 * 
	 * @param queryName query name
	 * @param param     input param
	 * @param val       value
	 * @return list of objects
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> List<T> getNamedQueryResult(String queryName, String param, String val) throws DAOException;

	/**
	 * Method to get single native query result with map params as input type
	 * 
	 * @param queryName query name
	 * @param params    input parameters
	 * @return string
	 * @throws DAOException Dao Layer Exceptions
	 */
	public String getNativeQueryResultNoClass(String queryName, Map<String, String> params) throws DAOException;

	/**
	 * Method to get single native query result with list type input params
	 * 
	 * @param queryName query name
	 * @param params    input parameters
	 * @return string
	 * @throws DAOException Dao Layer Exceptions
	 */
	public String getNativeQueryResultNoClass(String queryName, List<String> params) throws DAOException;

	/**
	 * Method to get Query object
	 * 
	 * @param queryString query String
	 * @return Query object
	 * @throws DAOException Dao Layer Exceptions
	 */
	public Query createQuery(String queryString) throws DAOException;

	/**
	 * Method to get Query object for create native query execution
	 * 
	 * @param queryString Query string
	 * @return Query object
	 * @throws DAOException Dao Layer Exceptions
	 */
	public Query createNativeQuery(String queryString) throws DAOException;

	/**
	 * Method to get the User name
	 * 
	 * @return username
	 * @throws DAOException Dao Layer Exceptions
	 */
	public String getUserName() throws DAOException;

	/**
	 * Method to get the CriteriaBuilder object
	 * 
	 * @return CriteriaBuilder object
	 * @throws DAOException Dao Layer Exceptions
	 */
	public CriteriaBuilder getCriteriaBuilder() throws DAOException;

	/**
	 * Method to flush the details
	 * 
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> void flush() throws DAOException;

	/**
	 * Method create the query with class
	 * 
	 * @param queryString queryString
	 * @param class1      classType
	 * @return Query
	 * @throws DAOException Dao Layer Exceptions
	 */
	public <T> Query createNativeQueryWithClass(String queryString, Class<T> class1) throws DAOException;

	/**
	 * Method to getCreateNamedQuery
	 * 
	 * @param queryString Query String
	 * @return Query
	 * @throws DAOException Dao Layer Exceptions
	 */
	public Query createNamedQuery(String queryString) throws DAOException;

	/**
	 * Method to get the Hibernate Session object through JPAEntityManager
	 * 
	 * @return <code>{@link Session}<Session> object
	 * @throws DAOException Dao Layer Exceptions
	 */
	public Session getSession() throws DAOException;

	/**
	 * @param spName
	 * @return
	 * @throws DAOException
	 */
	public StoredProcedureQuery createStoredProcedureQuery(String spName) throws DAOException;
}
