package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_Temp_Import_Order database table.
 * 
 */
@Entity
@Table(name="t_Temp_Import_Order")
@NamedQuery(name="TempImportOrder.findAll", query="SELECT t FROM TempImportOrder t")
public class TempImportOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Temp_Order_ID", unique=true, nullable=false)
	private int tempOrderId;

	@Column(name="Queue_ID")
	private int QueueId;

	@Column(name="Business_Unit", length=15)
	private String businessUnit;

	@Column(name="From_Address", length=100)
	private String fromAddress;

	@Column(name="From_Country", length=20)
	private String fromCountry;

	@Column(name="From_Latitude", length=20)
	private String fromLatitude;

	@Column(name="From_Longitude", length=20)
	private String fromLongitude;

	@Column(name="From_Phone", length=20)
	private String fromPhone;

	@Column(name="From_Province", length=30)
	private String fromProvince;

	@Column(name="From_Region", length=30)
	private String fromRegion;

	@Column(name="From_State", length=30)
	private String fromState;

	@Column(name="Line_Number", length=15)
	private String lineNumber;

	@Column(name="Order_Number", nullable=false, length=60)
	private String orderNumber;

	@Column(name="Order_Type", length=20)
	private String orderType;

	@Column(name="Product_Description", length=100)
	private String productDescription;

	@Column(name="Product_Type", length=30)
	private String productType;

	@Column(name="Qty")
	private int qty;

	@Column(name="Source", nullable=false, length=15)
	private String source;

	@Column(name="To_Address", length=100)
	private String toAddress;

	@Column(name="To_Country", length=20)
	private String toCountry;

	@Column(name="To_Latitude", length=20)
	private String toLatitude;

	@Column(name="To_Longitude", length=20)
	private String toLongitude;

	@Column(name="To_Phone", length=20)
	private String toPhone;

	@Column(name="To_Province", length=30)
	private String toProvince;

	@Column(name="To_Region", length=30)
	private String toRegion;

	@Column(name="To_State", length=30)
	private String toState;

	@Column(name="Volume")
	private int volume;

	public TempImportOrder() {
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getTempOrderId() {
		return tempOrderId;
	}

	public void setTempOrderId(int tempOrderId) {
		this.tempOrderId = tempOrderId;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getFromCountry() {
		return fromCountry;
	}

	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}

	public String getFromLatitude() {
		return fromLatitude;
	}

	public void setFromLatitude(String fromLatitude) {
		this.fromLatitude = fromLatitude;
	}

	public String getFromLongitude() {
		return fromLongitude;
	}

	public void setFromLongitude(String fromLongitude) {
		this.fromLongitude = fromLongitude;
	}

	public String getFromPhone() {
		return fromPhone;
	}

	public void setFromPhone(String fromPhone) {
		this.fromPhone = fromPhone;
	}

	public String getFromProvince() {
		return fromProvince;
	}

	public void setFromProvince(String fromProvince) {
		this.fromProvince = fromProvince;
	}

	public String getFromRegion() {
		return fromRegion;
	}

	public void setFromRegion(String fromRegion) {
		this.fromRegion = fromRegion;
	}

	public String getFromState() {
		return fromState;
	}

	public void setFromState(String fromState) {
		this.fromState = fromState;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getToCountry() {
		return toCountry;
	}

	public void setToCountry(String toCountry) {
		this.toCountry = toCountry;
	}

	public String getToLatitude() {
		return toLatitude;
	}

	public void setToLatitude(String toLatitude) {
		this.toLatitude = toLatitude;
	}

	public String getToLongitude() {
		return toLongitude;
	}

	public void setToLongitude(String toLongitude) {
		this.toLongitude = toLongitude;
	}

	public String getToPhone() {
		return toPhone;
	}

	public void setToPhone(String toPhone) {
		this.toPhone = toPhone;
	}

	public String getToProvince() {
		return toProvince;
	}

	public void setToProvince(String toProvince) {
		this.toProvince = toProvince;
	}

	public String getToRegion() {
		return toRegion;
	}

	public void setToRegion(String toRegion) {
		this.toRegion = toRegion;
	}

	public String getToState() {
		return toState;
	}

	public void setToState(String toState) {
		this.toState = toState;
	}

	public int getQueueId() {
		return QueueId;
	}

	public void setQueueId(int queueId) {
		QueueId = queueId;
	}


}