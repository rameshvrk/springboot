package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the t_Order database table.
 * 
 */
@Entity
@Table(name="t_Order")
@NamedQuery(name="Order.findAll", query="SELECT t FROM Order t")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Order_ID")
	private int orderID;

	@Column(name="Business_Unit_ID")
	private int businessUnitID;

	@Column(name="Created_By")
	private int createdBy;

	@Column(name="Created_Date")
	private Timestamp createdDate;

	@Column(name="From_Address")
	private String fromAddress;

	@Column(name="From_Country")
	private String fromCountry;

	@Column(name="From_Latitude")
	private String fromLatitude;

	@Column(name="From_Longitude")
	private String fromLongitude;

	@Column(name="From_Phone")
	private String fromPhone;

	@Column(name="From_Province")
	private String fromProvince;

	@Column(name="From_Region")
	private String fromRegion;

	@Column(name="From_State")
	private String fromState;

	@Column(name="Order_Number")
	private String orderNumber;

	@Column(name="Order_Type")
	private String orderType;

	@Column(name="Source")
	private String source;

	@Column(name="To_Address")
	private String toAddress;

	@Column(name="To_Country")
	private String toCountry;

	@Column(name="To_Latitude")
	private String toLatitude;

	@Column(name="To_Longitude")
	private String toLongitude;

	@Column(name="To_Phone")
	private String toPhone;

	@Column(name="To_Province")
	private String toProvince;

	@Column(name="To_Region")
	private String toRegion;

	@Column(name="To_State")
	private String toState;

	@Column(name="Updated_By")
	private int updatedBy;

	@Column(name="Updated_Date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to T_Order_Detail
	//@OneToMany(mappedBy="Order")
	//private List<OrderDetail> OrderDetails;

	public Order() {
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getBusinessUnitID() {
		return businessUnitID;
	}

	public void setBusinessUnitID(int businessUnitID) {
		this.businessUnitID = businessUnitID;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
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

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	

/*	public List<OrderDetail> getOrderDetails() {
		return this.OrderDetails;
	}

	public void setOrderDetails(List<OrderDetail> OrderDetails) {
		this.OrderDetails = OrderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail OrderDetail) {
		getOrderDetails().add(OrderDetail);
		OrderDetail.setOrder(this);

		return OrderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail OrderDetail) {
		getOrderDetails().remove(OrderDetail);
		OrderDetail.setOrder(null);

		return OrderDetail;
	}
*/
}