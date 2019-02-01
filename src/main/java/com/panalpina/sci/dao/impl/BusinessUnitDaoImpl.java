package com.panalpina.sci.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panalpina.sci.dao.BusinessUnitDao;
import com.panalpina.sci.dao.GenericDao;
import com.panalpina.sci.model.BusinessUnit;

/**
 * @author Cybage
 */
@Repository
@Transactional
public class BusinessUnitDaoImpl implements BusinessUnitDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public GenericDao genericDao;

	@Override
	public BusinessUnit findBusinessUnitByBusinessUnitId(int businessUnitId) {

		@SuppressWarnings("unchecked")
		List<BusinessUnit> businessUnitList = (List<BusinessUnit>) entityManager
				.createQuery("SELECT b FROM BusinessUnit b WHERE b.business_Unit_ID = :businessUnitId")
				.setParameter("businessUnitId", businessUnitId).getResultList();

		if (!businessUnitList.isEmpty()) {
			return businessUnitList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public BusinessUnit updateBusinessUnitDetails(BusinessUnit businessUnit) {

		return entityManager.merge(businessUnit);
	}

}