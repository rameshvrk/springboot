package com.panalpina.sci.scheduler;


import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.panalpina.sci.constants.IntegrationConstants.IntegrationFileTypes;
import com.panalpina.sci.constants.IntegrationConstants.IntegrationQueueStatus;
import com.panalpina.sci.exception.ServiceException;
import com.panalpina.sci.model.OrderQueue;
import com.panalpina.sci.service.InboundOrderQueuerService;


@Component
public class InboundPurchaseOrderScheduler {
	
	final static Logger logger = LogManager.getLogger(InboundPurchaseOrderScheduler.class);
	
	@Autowired
	private InboundOrderQueuerService inboundOrderQueuerService;
	
	/*@Autowired
	private EmailService amazonSESUtility;*/
	
	//@Value("${sci.email.poProcessing}")
	private String emailId;
	
	@Value("${sci.ftp.localFailDir}")
	private String failDirectory;
	
	private static final String NEW_LINE = "\n";
	private static final String LINE_BREAK = "<br/>";

	//@Scheduled(cron = "0 */1 * * * ?") // The cron expression runs every 1
	public void importPOPTData() {
		storePOData();
	}

	public void storePOData() {

		List<OrderQueue> filesToProcess = null;
		try {
			filesToProcess = inboundOrderQueuerService.integrationFileToProcess(IntegrationFileTypes.HKG.toString(), IntegrationQueueStatus.READYFORPROCESS.toString());
		} catch (ServiceException e2) {
			logger.error("Error while retrieving the integration Files");
		}
		if (filesToProcess == null || filesToProcess.isEmpty()) {
			logger.warn("No files to process");
			return;
		}

		for (OrderQueue orderQueue : filesToProcess) {
			//TODO Process EDI xml file which is having 'ready to process' status

			/*try {

			} catch (ServiceException e) {
				logger.error("Error in storePOData while processing the files from PO csv ");
			}*/
		}
	}


}
