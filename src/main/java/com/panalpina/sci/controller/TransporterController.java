package com.panalpina.sci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panalpina.sci.dto.TransporterDTO;
import com.panalpina.sci.exception.ServiceException;
import com.panalpina.sci.service.TransporterService;

@RestController
@RequestMapping("/transporter")
public class TransporterController {

	@Autowired
	private TransporterService transporterService;

	@GetMapping(value = "/getTransporterDetails")
	public List<TransporterDTO> getTransporterDetails() throws ServiceException {
		try {
			return transporterService.getTransporterDetails();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@GetMapping(value = "/getTransporterDetails/{transporterId}")
	public TransporterDTO getTransporterDetails(@PathVariable("transporterId") int transporterId)
			throws ServiceException {
		try {
			return transporterService.getTransporterDetails(transporterId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@PutMapping(value = "/updateTransporterDetails/{transportId}")
	public TransporterDTO updateTransporterDetails(@RequestBody TransporterDTO transporterDTO,
			@PathVariable("transporterId") int transporterId) throws ServiceException {
		try {
			return transporterService.updateTransporterDetails(transporterDTO, transporterId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
