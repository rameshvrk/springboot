package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_Time_Zone database table.
 * 
 */
@Entity
@Table(name="t_Time_Zone")
@NamedQuery(name="TimeZone.findAll", query="SELECT t FROM TimeZone t")
public class TimeZone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Time_Zone_ID", unique=true, nullable=false)
	private int timeZoneID;

	@Column(name="Country", length=20)
	private String country;

	@Column(name="Description", length=50)
	private String description;

	public int getTimeZoneID() {
		return timeZoneID;
	}

	public void setTimeZoneID(int timeZoneID) {
		this.timeZoneID = timeZoneID;
	}

	public TimeZone() {
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}