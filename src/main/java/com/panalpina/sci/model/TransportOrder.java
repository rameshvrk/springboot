package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the t_Transport_Order database table.
 * 
 */
@Entity
@Table(name = "t_Transport_Order")
@NamedQueries({ @NamedQuery(name = "TransportOrder.findAll", query = "SELECT t FROM TransportOrder t") })
public class TransportOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Transport_Order_ID")
	private int transportOrderID;

	@Column(name = "Accepted_Date")
	private Timestamp acceptedDate;

	@Column(name = "Assigned_Date")
	private Timestamp assignedDate;

	@Column(name = "Business_Unit_ID")
	private int businessUnitID;

	@Column(name = "Consignee")
	private String consignee;

	@Column(name = "Driver_ID")
	private int driverID;

	@Column(name = "Driver_Name")
	private String driverName;

	@Column(name = "Drop_Location")
	private String dropLocation;

	@Column(name = "Line_Number")
	private String lineNumber;

	@Column(name = "Order_ID")
	private int orderID;

	@Column(name = "Pickup_Location")
	private String pickupLocation;

	@Column(name = "Product_Description")
	private String productDescription;

	@Column(name = "Product_Type")
	private String productType;

	@Column(name = "Qty")
	private int qty;

	@Column(name = "Remarks")
	private String remarks;

	@Column(name = "Shipper")
	private String shipper;

	@Column(name = "Status_ID")
	private int statusID;

	@Column(name = "Transporter_ID")
	private int transporterID;

	@Column(name = "Vehicle_ID")
	private int vehicleID;

	@Column(name = "Volume")
	private double volume;

	@Column(name = "Volume_UOM")
	private String volumeUOM;

	@Column(name = "Weight")
	private double weight;

	@Column(name = "Weight_UOM")
	private String weightUOM;

	// bi-directional many-to-one association to T_User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Assigned_By")
	private User user1;

	// bi-directional many-to-one association to T_User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Accepted_By")
	private User user2;

	// bi-directional many-to-one association to T_ePOD_Attachment
	// @OneToMany(mappedBy="TransportOrder")
	// private List<EpodAttachment> ePodAttachments;

	public TransportOrder() {
	}

	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getShipper() {
		return this.shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public double getVolume() {
		return this.volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getTransportOrderID() {
		return transportOrderID;
	}

	public void setTransportOrderID(int transportOrderID) {
		this.transportOrderID = transportOrderID;
	}

	public Timestamp getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(Timestamp acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public Timestamp getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Timestamp assignedDate) {
		this.assignedDate = assignedDate;
	}

	public int getBusinessUnitID() {
		return businessUnitID;
	}

	public void setBusinessUnitID(int businessUnitID) {
		this.businessUnitID = businessUnitID;
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public int getTransporterID() {
		return transporterID;
	}

	public void setTransporterID(int transporterID) {
		this.transporterID = transporterID;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getVolumeUOM() {
		return volumeUOM;
	}

	public void setVolumeUOM(String volumeUOM) {
		this.volumeUOM = volumeUOM;
	}

	public String getWeightUOM() {
		return weightUOM;
	}

	public void setWeightUOM(String weightUOM) {
		this.weightUOM = weightUOM;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User TUser2) {
		this.user2 = user2;
	}

}