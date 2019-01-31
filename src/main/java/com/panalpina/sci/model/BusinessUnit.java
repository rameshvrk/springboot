package com.panalpina.sci.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the t_Business_Unit database table.
 * 
 */
@Entity
@Table(name = "t_Business_Unit")
@NamedQuery(name = "BusinessUnit.findAll", query = "SELECT t FROM BusinessUnit t")
public class BusinessUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Business_Unit_ID", unique = true, nullable = false)
	private int business_Unit_ID;

	@Column(name = "BU_Code", nullable = false, length = 15)
	private String businessUnitCode;

	@Column(name = "BU_Name", nullable = false, length = 50)
	private String businessUnitName;

	@Column(name = "Contact_Name", length = 30)
	private String contactName;

	@Column(name = "Country", length = 20)
	private String country;

	@Column(name = "Email_Address", length = 30)
	private String emailAddress;

	@Column(name = "Phone", length = 20)
	private String phone;

	@Column(name = "Province", length = 30)
	private String province;

	@Column(name = "Region", length = 30)
	private String region;

	@Column(name = "State", length = 30)
	private String state;

	// bi-directional many-to-one association to T_Order
	// @OneToMany(mappedBy="BusinessUnit")
	// private List<Order> orders;

	public BusinessUnit() {
	}

	public int getBusiness_Unit_ID() {
		return this.business_Unit_ID;
	}

	public void setBusiness_Unit_ID(int business_Unit_ID) {
		this.business_Unit_ID = business_Unit_ID;
	}

	public String getBusinessUnitCode() {
		return businessUnitCode;
	}

	public void setBusinessUnitCode(String businessUnitCode) {
		this.businessUnitCode = businessUnitCode;
	}

	public String getBusinessUnitName() {
		return businessUnitName;
	}

	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}