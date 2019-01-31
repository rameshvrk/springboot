package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_Email_Configuration database table.
 * 
 */
@Entity
@Table(name="t_Email_Configuration")
@NamedQuery(name="EmailConfiguration.findAll", query="SELECT t FROM EmailConfiguration t")
public class EmailConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Email_Configuration_ID", unique=true, nullable=false)
	private int emailConfigurationID;

	@Column(name="Comments", length=255)
	private String comments;

	@Column(name="Email_Body", length=255)
	private String emailBody;

	@Column(name="Email_CC", length=255)
	private String emailCC;

	@Column(name="Email_Description", length=50)
	private String emailDescription;

	@Column(name="Email_To_Address", length=50)
	private String emailToAddress;

	@Column(name="Status_Code", length=15)
	private String statusCode;

	public EmailConfiguration() {
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getEmailConfigurationID() {
		return emailConfigurationID;
	}

	public void setEmailConfigurationID(int emailConfigurationID) {
		this.emailConfigurationID = emailConfigurationID;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getEmailCC() {
		return emailCC;
	}

	public void setEmailCC(String emailCC) {
		this.emailCC = emailCC;
	}

	public String getEmailDescription() {
		return emailDescription;
	}

	public void setEmailDescription(String emailDescription) {
		this.emailDescription = emailDescription;
	}

	public String getEmailToAddress() {
		return emailToAddress;
	}

	public void setEmailToAddress(String emailToAddress) {
		this.emailToAddress = emailToAddress;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	

}