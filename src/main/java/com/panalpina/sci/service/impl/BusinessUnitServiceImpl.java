package com.panalpina.sci.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.panalpina.sci.dao.BusinessUnitDao;
import com.panalpina.sci.dto.BusinessUnitDTO;
import com.panalpina.sci.model.BusinessUnit;
import com.panalpina.sci.service.BusinessUnitService;

@Service
public class BusinessUnitServiceImpl implements BusinessUnitService {

	@Autowired
	private BusinessUnitDao businessUnitDao;

	@Override
	public BusinessUnitDTO getBusinessUnitDetails(int businessUnitId) {
		BusinessUnit businessUnit = businessUnitDao.findBusinessUnitByBusinessUnitId(businessUnitId);

		return setBusinessUnitToBusinessUnitDTO(businessUnit);

	}

	@Override
	public BusinessUnitDTO updateBusinessUnitDetails(BusinessUnitDTO businessUnitDTO, int businessUnitId) {

		BusinessUnit businessUnit = businessUnitDao.findBusinessUnitByBusinessUnitId(businessUnitId);

		setBusinessUnitDTOToBusinessUnit(businessUnit, businessUnitDTO);

		businessUnit = businessUnitDao.updateBusinessUnitDetails(businessUnit);

		return setBusinessUnitToBusinessUnitDTO(businessUnit);
	}

	private BusinessUnitDTO setBusinessUnitToBusinessUnitDTO(BusinessUnit businessUnit) {
		BusinessUnitDTO buDTO = new BusinessUnitDTO();

		buDTO.setBuCode(businessUnit.getBusinessUnitCode());
		buDTO.setBuName(businessUnit.getBusinessUnitName());
		buDTO.setBusinessUnitId(businessUnit.getBusiness_Unit_ID());
		buDTO.setContactName(businessUnit.getContactName());
		buDTO.setCountry(businessUnit.getCountry());
		buDTO.setEmailAddress(businessUnit.getEmailAddress());
		buDTO.setPhone(businessUnit.getPhone());
		buDTO.setProvince(businessUnit.getProvince());
		buDTO.setRegion(businessUnit.getRegion());
		buDTO.setState(businessUnit.getState());

		return buDTO;
	}

	private void setBusinessUnitDTOToBusinessUnit(BusinessUnit businessUnit, BusinessUnitDTO businessUnitDTO) {
		if (!StringUtils.isEmpty(businessUnitDTO.getBuCode())) {
			businessUnit.setBusinessUnitCode(businessUnitDTO.getBuCode());
		}

		if (!StringUtils.isEmpty(businessUnitDTO.getBuName())) {
			businessUnit.setBusinessUnitName(businessUnitDTO.getBuName());
		}

		if (!StringUtils.isEmpty(businessUnitDTO.getContactName())) {
			businessUnit.setContactName(businessUnitDTO.getContactName());
		}

		if (!StringUtils.isEmpty(businessUnitDTO.getCountry())) {
			businessUnit.setCountry(businessUnitDTO.getCountry());
		}

		if (!StringUtils.isEmpty(businessUnitDTO.getEmailAddress())) {
			businessUnit.setEmailAddress(businessUnitDTO.getEmailAddress());
		}

		if (!StringUtils.isEmpty(businessUnitDTO.getPhone())) {
			businessUnit.setPhone(businessUnitDTO.getPhone());
		}

		if (!StringUtils.isEmpty(businessUnitDTO.getProvince())) {
			businessUnit.setProvince(businessUnitDTO.getProvince());
		}

		if (!StringUtils.isEmpty(businessUnitDTO.getRegion())) {
			businessUnit.setRegion(businessUnitDTO.getRegion());
		}

		if (!StringUtils.isEmpty(businessUnitDTO.getState())) {
			businessUnit.setState(businessUnitDTO.getState());
		}
	}
}
