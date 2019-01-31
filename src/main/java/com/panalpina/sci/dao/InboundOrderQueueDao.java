package com.panalpina.sci.dao;


import java.util.List;

import com.panalpina.sci.exception.DAOException;
import com.panalpina.sci.model.OrderQueue;
import com.panalpina.sci.model.TempImportOrder;


public interface InboundOrderQueueDao {

	
	/**
	 * Method to save <code>{@link OrderQueue}</code> details
	 * 
	 * @param OrderQueue
	 *            <code>{@link OrderQueue}</code> object
	 * @return Updated <code>OrderQueue</code> object
	 * @throws DAOException
	 */
	public OrderQueue insertIntoOrderQueue(OrderQueue orderQueue) throws DAOException;


	/**
	 * @param orderQueue
	 */
	public void updateOrderQueue(OrderQueue orderQueue) throws DAOException;


	public void insertTempImportOrdersToTempTable(TempImportOrder tempImportOrder) throws DAOException;
}
