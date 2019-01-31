package com.panalpina.sci.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panalpina.sci.dao.GenericDao;
import com.panalpina.sci.dao.TransporterDao;
import com.panalpina.sci.model.Transporter;

/**
 * @author Cybage
 */
@Repository
@Transactional
public class TransporterDaoImpl implements TransporterDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public GenericDao genericDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Transporter> findAllTransporters() {

		return (List<Transporter>) entityManager.createNamedQuery("Transporter.findAll").getResultList();

	}

	@Override
	public Transporter findTransporterByTransporterId(int transporterId) {

		@SuppressWarnings("unchecked")
		List<Transporter> transporterList = (List<Transporter>) entityManager
				.createQuery("SELECT t FROM Transporter t WHERE t.transporterId = :transporterId")
				.setParameter("transporterId", transporterId).getResultList();

		if (!transporterList.isEmpty()) {
			return transporterList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Transporter updateTransporterDetails(Transporter transporter) {
		return entityManager.merge(transporter);
	}

}