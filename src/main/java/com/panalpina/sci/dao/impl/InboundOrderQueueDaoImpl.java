package com.panalpina.sci.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.panalpina.sci.dao.GenericDao;
import com.panalpina.sci.dao.InboundOrderQueueDao;
import com.panalpina.sci.exception.DAOException;
import com.panalpina.sci.model.OrderQueue;
import com.panalpina.sci.model.TempImportOrder;
import com.panalpina.sci.util.Util;

@Repository
@Transactional
public class InboundOrderQueueDaoImpl implements InboundOrderQueueDao {

	public final static Logger logger = LogManager.getLogger(InboundOrderQueueDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private GenericDao genericDao;

	@SuppressWarnings("unchecked")
	@Override
	public OrderQueue insertIntoOrderQueue(OrderQueue orderQueue) throws DAOException {
		OrderQueue queue = null;
		List<OrderQueue> queues = entityManager
				.createNativeQuery("SELECT * FROM t_Order_Queue where File_Name =:fileName")
				.setParameter("fileName", orderQueue.getFileName()).getResultList();
		if (Util.isCollectionEmpty(queues)) {
			queue = genericDao.insert(orderQueue);
		}

		return queue;
	}

	@Override
	public void updateOrderQueue(OrderQueue orderQueue) throws DAOException {
		genericDao.update(orderQueue);
	}

	@Override
	public void insertTempImportOrdersToTempTable(TempImportOrder tempImportOrder) throws DAOException {
		genericDao.insert(tempImportOrder);

	}

}
