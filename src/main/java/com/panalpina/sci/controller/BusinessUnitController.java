package com.panalpina.sci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panalpina.sci.dto.BusinessUnitDTO;
import com.panalpina.sci.exception.ServiceException;
import com.panalpina.sci.service.BusinessUnitService;

@RestController
@RequestMapping("/businessUnit")
public class BusinessUnitController {

	@Autowired
	private BusinessUnitService businessUnitService;

	@GetMapping(value = "/getBusinessUnitDetails/{businessUnitId}")
	public BusinessUnitDTO getBusinessUnitDetails(@PathVariable("businessUnitId") int businessUnitId)
			throws ServiceException {
		try {
			return businessUnitService.getBusinessUnitDetails(businessUnitId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@PutMapping(value = "/updateBusinessUnitDetails/{businessUnitId}")
	public BusinessUnitDTO updateBusinessUnitDetails(@RequestBody BusinessUnitDTO businessUnitDTO,
			@PathVariable("businessUnitId") int businessUnitId) throws ServiceException {
		try {
			return businessUnitService.updateBusinessUnitDetails(businessUnitDTO, businessUnitId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
