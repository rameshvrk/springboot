package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the t_User database table.
 * 
 */
@Entity
@Table(name = "t_User")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID", unique = true, nullable = false)
	private int userID;

	@Column(name = "Business_Unit_ID", nullable = false)
	private int businessUnitID;

	@Column(name = "Email_Address", length = 30)
	private String emailAddress;

	@Column(name = "First_Name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "IsActive", nullable = false, length = 1)
	private String isActive;

	@Column(name = "Language_ID")
	private int languageID;

	@Column(name = "Last_Name", length = 50)
	private String lastName;

	@Column(name = "Password", nullable = false, length = 30)
	private String password;

	@Column(name = "Phone", length = 20)
	private String phone;

	@Column(name = "Role_ID", nullable = false)
	private int roleID;

	@Column(name = "Time_Zone_ID")
	private int timeZoneID;

	@Column(name = "User_Name", nullable = false, length = 50)
	private String userName;

	public User() {
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getBusinessUnitID() {
		return businessUnitID;
	}

	public void setBusinessUnitID(int businessUnitID) {
		this.businessUnitID = businessUnitID;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getLanguageID() {
		return languageID;
	}

	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getTimeZoneID() {
		return timeZoneID;
	}

	public void setTimeZoneID(int timeZoneID) {
		this.timeZoneID = timeZoneID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}