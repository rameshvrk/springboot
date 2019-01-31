package com.panalpina.sci.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.panalpina.sci.model.Transporter;

/**
 *
 * @author Cybage
 *
 */
@Component
public interface TransporterDao {

	public List<Transporter> findAllTransporters();

	public Transporter findTransporterByTransporterId(int transporterId);

	public Transporter updateTransporterDetails(Transporter transporter);

}
