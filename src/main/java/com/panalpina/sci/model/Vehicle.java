package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the t_Vehicle database table.
 * 
 */
@Entity
@Table(name = "t_Vehicle")
@NamedQuery(name = "Vehicle.findAll", query = "SELECT t FROM Vehicle t")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Vehicle_ID", unique = true, nullable = false)
	private int vehicleID;

	@Column(name = "Created_Date")
	private Timestamp createdDate;

	@Column(name = "Fumigation_Required", length = 1)
	private String fumigationRequired;

	@Column(name = "License_Plate", nullable = false, length = 20)
	private String licensePlate;

	@Column(name = "Type", length = 30)
	private String type;

	@Column(name = "Vehicle_Code", nullable = false, length = 20)
	private String vehicleCode;

	@Column(name = "Vessel_Type", length = 20)
	private String vesselType;

	// bi-directional many-to-one association to T_Transporter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Operated_By", nullable = false)
	private Transporter TTransporter;

	// bi-directional many-to-one association to T_User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Created_By")
	private User user;

	public Vehicle() {
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getFumigationRequired() {
		return fumigationRequired;
	}

	public void setFumigationRequired(String fumigationRequired) {
		this.fumigationRequired = fumigationRequired;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = vehicleCode;
	}

	public String getVesselType() {
		return vesselType;
	}

	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}

	public Transporter getTTransporter() {
		return this.TTransporter;
	}

	public void setTTransporter(Transporter TTransporter) {
		this.TTransporter = TTransporter;
	}

	public User getUser() {
		return this.user;
	}

	public void setTUser(User user) {
		this.user = user;
	}

}