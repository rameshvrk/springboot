package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_Reason database table.
 * 
 */
@Entity
@Table(name="t_Reason")
@NamedQuery(name="Reason.findAll", query="SELECT t FROM Reason t")
public class Reason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Reason_ID", unique=true, nullable=false)
	private int reasonID;

	@Column(name="Comments", length=255)
	private String comments;

	@Column(name="Description", length=50)
	private String description;

	@Column(name="Reason_Code", nullable=false, length=20)
	private String reasonCode;

	public Reason() {
	}

	public int getReasonID() {
		return reasonID;
	}

	public void setReasonID(int reasonID) {
		this.reasonID = reasonID;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}