package com.panalpina.sci.service;

import org.springframework.stereotype.Component;

import com.panalpina.sci.dto.BusinessUnitDTO;

@Component
public interface BusinessUnitService {

	public BusinessUnitDTO getBusinessUnitDetails(int businessUnitId);

	public BusinessUnitDTO updateBusinessUnitDetails(BusinessUnitDTO businessUnitDTO, int businessUnitId);

}
