package com.panalpina.sci.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.panalpina.sci.dao.InboundOrderQueueDao;
import com.panalpina.sci.exception.DAOException;
import com.panalpina.sci.exception.ServiceException;
import com.panalpina.sci.model.OrderQueue;
import com.panalpina.sci.model.TempImportOrder;
import com.panalpina.sci.service.InboundOrderQueuerService;


@Service
public class InboundOrderQueuerServiceImpl implements InboundOrderQueuerService {

	public final static Logger logger = LogManager.getLogger(InboundOrderQueuerServiceImpl.class);

	@Autowired
	private InboundOrderQueueDao inboundOrderQueueDao;

	@Override
	public OrderQueue insertFileToOrderQueue(OrderQueue orderQueue) throws ServiceException {
		try {
			return inboundOrderQueueDao.insertIntoOrderQueue(orderQueue);
		} catch (DAOException e) {
			logger.error("Exception in insertFileToOrderQueue: ", e);
			throw new ServiceException(e.getMessage());
		}
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void insertTempImportOrdersToTempTable(List<TempImportOrder> tempImportOrders) throws ServiceException {
		for (TempImportOrder tempImportOrder : tempImportOrders) {
			try {
				inboundOrderQueueDao.insertTempImportOrdersToTempTable(tempImportOrder);
			} catch (DAOException e) {
				logger.error("Exception in insertTempImportOrdersToTempTable: ", e);
				logger.debug("Failed to insert/update the PurchaseOrder " + tempImportOrders.toString());
			}
		}
	}

	@Override
	public void updateOrderQueue(OrderQueue orderQueue) throws ServiceException {
		try {
			inboundOrderQueueDao.updateOrderQueue(orderQueue);
		} catch (DAOException e) {
			logger.error("Exception in updateOrderQueue: " , e);
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<OrderQueue> integrationFileToProcess(String fileType, String status) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
