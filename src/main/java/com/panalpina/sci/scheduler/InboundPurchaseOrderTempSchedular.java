package com.panalpina.sci.scheduler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.panalpina.sci.constants.IntegrationConstants;
import com.panalpina.sci.exception.ServiceException;
import com.panalpina.sci.fileprocess.FileConnectorService;
import com.panalpina.sci.model.OrderQueue;
import com.panalpina.sci.model.TempImportOrder;
import com.panalpina.sci.service.InboundOrderQueuerService;
import com.panalpina.sci.util.DateUtil;
import com.panalpina.sci.xml.Filetxt;
import com.panalpina.sci.xml.PullScpCompleteFileResponse;
import com.panalpina.sci.xml.Routing;

@Component
public class InboundPurchaseOrderTempSchedular {

	private final static Logger logger = LogManager.getLogger(InboundPurchaseOrderTempSchedular.class);

	@Autowired
	private FileConnectorService fileConnectorService;

	@Autowired
	private InboundOrderQueuerService inboundOrderQueuerService;

	@Scheduled(cron = "0 */1 * * * ?") // The cron expression runs every 1
	public void importPOData() {
		try {
			List<String> xmlFileList = fileConnectorService.getFile(IntegrationConstants.REGEX);
			for (String xmlFile : xmlFileList) {
				storeEDIDataIntoTempTable(xmlFile);
				// storePODataIntoTempTable(csvFile);
			}
			fileConnectorService.archiveFiles(xmlFileList);

		} catch (ServiceException e) {
			logger.error("Error processing the PO files from FTP");
		}

	}

	/**
	 * @throws ServiceException
	 */
	private void storeEDIDataIntoTempTable(String xmlFile) throws ServiceException {

		try {
			if (null != xmlFile && !"".equals(xmlFile)) {
				OrderQueue orderQueue = new OrderQueue();

				orderQueue.setCreatedDate(DateUtil.getSqlTimestamp());
				orderQueue.setFileName(xmlFile);
				// orderQueue.setFileType("EDI");
				orderQueue.setStatus("NEW");

				/*
				 * 1. Store the File name to DB so that other scheduler process this file. 2. If
				 * the file name already exists then integrationQueue will be null, so do not
				 * process the records.
				 */
				logger.debug("Storing the file name: " + xmlFile);

				orderQueue=inboundOrderQueuerService.insertFileToOrderQueue(orderQueue);
				
				if (orderQueue == null) {
					logger.warn("File already processed: " + xmlFile);
					return;
				}
				
				List<TempImportOrder> tempImportOrders = new ArrayList<>();
				
				int queueId = orderQueue.getQueueID();
				
				TempImportOrder tempImportOrder = populateTempImportOrder(xmlFile,queueId);
				tempImportOrders.add(tempImportOrder);

				// DB call to store the map details
			   inboundOrderQueuerService.insertTempImportOrdersToTempTable(tempImportOrders);
				logger.debug("processing of temp file " + xmlFile + "is done and stored to temp schema");
			
				//Update the status of integrationQueue
				orderQueue.setStatus("READYFORPROCESS");
				inboundOrderQueuerService.updateOrderQueue(orderQueue);
			} else {
				logger.warn("NO Po file to process");
			}

		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * @param xmlFile
	 * @return OrderQueue
	 * @throws IOException
	 */
	private TempImportOrder populateTempImportOrder(String xmlFile, int queueId) throws IOException {

		TempImportOrder tempImportOrder = new TempImportOrder();

		try {	
			JAXBContext jaxbContext = JAXBContext.newInstance(PullScpCompleteFileResponse.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			PullScpCompleteFileResponse pullScpCompleteFileResponse = (PullScpCompleteFileResponse) jaxbUnmarshaller
					.unmarshal(new File(xmlFile));

			System.out.println("PullScpCompleteFileReturn: "
					+ pullScpCompleteFileResponse.getPullScpCompleteFileReturn().getRoutings().size());

			//TODO extract required properties once final EDI message file available from the client
			for (Routing routing : pullScpCompleteFileResponse.getPullScpCompleteFileReturn().getRoutings()) {
				//System.out.println("FiledId:" + routing.getFileid());
				//System.out.println("RoutingId:" + routing.getRoutid());
			}

			for (Filetxt filetxt : pullScpCompleteFileResponse.getPullScpCompleteFileReturn().getFiletxts()) {
				//System.out.println("FiledId:" + filetxt.getFileid());
				//System.out.println("TxtId:" + filetxt.getTxtid());
			}
			tempImportOrder.setBusinessUnit("BUnit1");
			tempImportOrder.setFromCountry("India");
			tempImportOrder.setOrderNumber("12345");
			tempImportOrder.setSource("AirImport");
			tempImportOrder.setQueueId(queueId);

			/*
			 * String filename = xmlFile.getName(); // Rename file after successful
			 * parsing/persisting if (!renameFile(xmlFile, fileLocation)) {
			 * logger.warn(filename + " file rename failed"); }
			 */
		} catch (JAXBException e) {
			logger.error("Failed to parse EDI message:" + e.getMessage());
		}

		return tempImportOrder;
	}

}
