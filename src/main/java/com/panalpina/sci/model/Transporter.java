package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the t_Transporter database table.
 * 
 */
@Entity
@Table(name = "t_Transporter")
@NamedQuery(name = "Transporter.findAll", query = "SELECT t FROM Transporter t")
public class Transporter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Transporter_ID", unique = true, nullable = false)
	private int transporterID;

	@Column(name = "Address", length = 255)
	private String address;

	@Column(name = "Contact_Name", length = 50)
	private String contactName;

	@Column(name = "Country", length = 20)
	private String country;

	@Column(name = "Created_Date")
	private Timestamp createdDate;

	@Column(name = "Email_Address", length = 20)
	private String emailAddress;

	@Column(name = "IsActive", nullable = false, length = 1)
	private String isActive;

	@Column(name = "Phone", length = 20)
	private String phone;

	@Column(name = "Province", length = 30)
	private String province;

	@Column(name = "Region", length = 30)
	private String region;

	@Column(name = "State", length = 30)
	private String state;

	@Column(name = "Transporter_Code", nullable = false, length = 20)
	private String transporterCode;

	@Column(name = "Transporter_Name", nullable = false, length = 50)
	private String transporterName;

	@Column(name = "Trucks")
	private int trucks;

	// bi-directional many-to-one association to T_User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Created_By", nullable = false)
	private User user;

	// bi-directional many-to-one association to T_Vehicle
	@OneToMany(mappedBy = "TTransporter")
	private List<Vehicle> TVehicles;

	public Transporter() {
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
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

	public int getTransporterID() {
		return transporterID;
	}

	public void setTransporterID(int transporterID) {
		this.transporterID = transporterID;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTransporterCode() {
		return transporterCode;
	}

	public void setTransporterCode(String transporterCode) {
		this.transporterCode = transporterCode;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public int getTrucks() {
		return this.trucks;
	}

	public void setTrucks(int trucks) {
		this.trucks = trucks;
	}

	public User getUser() {
		return this.user;
	}

	public void setTUser(User user) {
		this.user = user;
	}

	public List<Vehicle> getTVehicles() {
		return this.TVehicles;
	}

	public void setTVehicles(List<Vehicle> TVehicles) {
		this.TVehicles = TVehicles;
	}

	public Vehicle addTVehicle(Vehicle TVehicle) {
		getTVehicles().add(TVehicle);
		TVehicle.setTTransporter(this);

		return TVehicle;
	}

	public Vehicle removeTVehicle(Vehicle TVehicle) {
		getTVehicles().remove(TVehicle);
		TVehicle.setTTransporter(null);

		return TVehicle;
	}

}