package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_Status database table.
 * 
 */
@Entity
@Table(name="t_Status")
@NamedQuery(name="Status.findAll", query="SELECT t FROM Status t")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Status_ID", unique=true, nullable=false)
	private int statusID;

	@Column(name="Description", length=30)
	private String description;

	@Column(name="Status_Code", nullable=false, length=15)
	private String statusCode;

	public Status() {
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}