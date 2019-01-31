package com.panalpina.sci.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.panalpina.sci.dao.TransporterDao;
import com.panalpina.sci.dto.TransporterDTO;
import com.panalpina.sci.model.Transporter;
import com.panalpina.sci.service.TransporterService;

@Service
public class TransporterServiceImpl implements TransporterService {

	@Autowired
	private TransporterDao transporterDao;

	@Override
	public List<TransporterDTO> getTransporterDetails() {
		List<Transporter> transporterList = transporterDao.findAllTransporters();

		return transporterList.stream().map(transporter -> setTransporterTOTransporterDTO(transporter))
				.collect(Collectors.toList());
	}

	@Override
	public TransporterDTO getTransporterDetails(int transporterId) {

		Transporter transporter = transporterDao.findTransporterByTransporterId(transporterId);

		return setTransporterTOTransporterDTO(transporter);

	}

	@Override
	public TransporterDTO updateTransporterDetails(TransporterDTO transporterDTO, int transporterId) {

		Transporter transporter = transporterDao.findTransporterByTransporterId(transporterId);

		setTransporterDTOTOTransporter(transporter, transporterDTO);

		transporter = transporterDao.updateTransporterDetails(transporter);

		return setTransporterTOTransporterDTO(transporter);

	}

	private TransporterDTO setTransporterTOTransporterDTO(Transporter transporter) {
		TransporterDTO transporterDTO = new TransporterDTO();

		transporterDTO.setAddress(transporter.getAddress());
		transporterDTO.setContactName(transporter.getContactName());
		transporterDTO.setCountry(transporter.getCountry());
		transporterDTO.setCreatedDate(transporter.getCreatedDate());
		transporterDTO.setEmailAddress(transporter.getEmailAddress());
		transporterDTO.setIsActive(transporter.getIsActive());
		transporterDTO.setPhone(transporter.getPhone());
		transporterDTO.setProvince(transporter.getProvince());
		transporterDTO.setRegion(transporter.getRegion());
		transporterDTO.setState(transporter.getState());
		transporterDTO.setTransporterCode(transporter.getTransporterCode());
		transporterDTO.setTransporterId(transporter.getTransporterID());
		transporterDTO.setTransporterName(transporter.getTransporterName());
		transporterDTO.setTrucks(transporter.getTrucks());

		return transporterDTO;
	}

	private void setTransporterDTOTOTransporter(Transporter transporter, TransporterDTO transporterDTO) {

		if (!StringUtils.isEmpty(transporterDTO.getContactName())) {
			transporter.setContactName(transporterDTO.getContactName());
		}

		if (!StringUtils.isEmpty(transporterDTO.getEmailAddress())) {
			transporter.setEmailAddress(transporterDTO.getEmailAddress());
		}

		if (!StringUtils.isEmpty(transporterDTO.getPhone())) {
			transporter.setPhone(transporterDTO.getPhone());
		}

		if (!StringUtils.isEmpty(transporterDTO.getProvince())) {
			transporter.setProvince(transporterDTO.getProvince());
		}

		if (!StringUtils.isEmpty(transporterDTO.getRegion())) {
			transporter.setRegion(transporterDTO.getRegion());
		}

		if (!StringUtils.isEmpty(transporterDTO.getState())) {
			transporter.setState(transporterDTO.getState());
		}

		if (!StringUtils.isEmpty(transporterDTO.getTransporterCode())) {
			transporter.setTransporterCode(transporterDTO.getTransporterCode());
		}

		if (!StringUtils.isEmpty(transporterDTO.getTransporterName())) {
			transporter.setTransporterName(transporterDTO.getTransporterName());
		}

		if (!StringUtils.isEmpty(String.valueOf(transporterDTO.getTrucks()))) {
			transporter.setTrucks(transporterDTO.getTrucks());
		}
	}
}
