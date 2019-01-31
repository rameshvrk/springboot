package com.panalpina.sci.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.panalpina.sci.dto.TransporterDTO;

@Component
public interface TransporterService {

	List<TransporterDTO> getTransporterDetails();

	TransporterDTO getTransporterDetails(int transportId);

	TransporterDTO updateTransporterDetails(TransporterDTO transporterDTO, int transportId);

}
