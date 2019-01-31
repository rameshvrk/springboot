package com.panalpina.sci.dao;

import org.springframework.stereotype.Component;

import com.panalpina.sci.model.BusinessUnit;

/**
 *
 * @author Cybage
 *
 */
@Component
public interface BusinessUnitDao {

	public BusinessUnit findBusinessUnitByBusinessUnitId(int businessUnitId);

	public BusinessUnit updateBusinessUnitDetails(BusinessUnit businessUnit);

}
