package com.panalpina.sci.service;

import java.util.List;

import com.panalpina.sci.exception.ServiceException;
import com.panalpina.sci.model.OrderQueue;
import com.panalpina.sci.model.TempImportOrder;


public interface InboundOrderQueuerService {

	/**
	 * Method to insert PurchaseOrders to Temperory Table
	 * 
	 * @param poRecords
	 *            List of PurchaseOrders
	 * @throws ServiceException
	 */
	//public void insertPurchaseOrdersToTempTable(List<PurchaseOrder> poRecords) throws ServiceException;

	/**
	 * Method to insert File to the IntegrationQueue
	 * 
	 * @param integrationQueue
	 *            IntegrationQueue object
	 * @return updated IntegrationQueue object
	 * @throws ServiceException
	 */
	//public IntegrationQueue insertFileToIntegrationQueue(IntegrationQueue integrationQueue) throws ServiceException;
	public OrderQueue insertFileToOrderQueue(OrderQueue orderQueue) throws ServiceException;

	public void insertTempImportOrdersToTempTable(List<TempImportOrder> tempImportOrders) throws ServiceException;

	public void updateOrderQueue(OrderQueue orderQueue) throws ServiceException;

	 /* Method to get list of integrationFile object to Process by file type and
	 * status of the integration file
	 * 
	 * @param fileType
	 *            File Type
	 * @param status
	 *            Status of the file
	 * @return List of OrderQueue
	 * @throws ServiceException
	 */
	public List<OrderQueue> integrationFileToProcess(String fileType, String status) throws ServiceException;

}
