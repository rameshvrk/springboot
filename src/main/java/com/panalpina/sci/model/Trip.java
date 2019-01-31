package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the t_Trip database table.
 * 
 */
@Entity
@Table(name = "t_Trip")
@NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t")
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Trip_ID")
	private int tripID;

	@Column(name = "Created_Date")
	private Timestamp createdDate;

	@Column(name = "Finished_Date")
	private Timestamp finishedDate;

	@Column(name = "Reason_ID")
	private int reasonID;

	@Column(name = "Sequence")
	private int sequence;

	@Column(name = "Started_Date")
	private Timestamp startedDate;

	@Column(name = "Status_Code")
	private String statusCode;

	@Column(name = "Status_ID")
	private int statusID;

	@Column(name = "Transporter_Order_ID")
	private int transporterOrderID;

	// bi-directional many-to-one association to T_User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Created_By")
	private User user1;

	// bi-directional many-to-one association to T_User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Started_By")
	private User user2;

	// bi-directional many-to-one association to T_User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Finished_By")
	private User user3;

	/*
	 * //bi-directional many-to-one association to T_ePOD_Attachment
	 * 
	 * @OneToMany(mappedBy="Trip") private List<EpodAttachment> ePodAttachments;
	 */

	public Trip() {
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public int getTripID() {
		return tripID;
	}

	public void setTripID(int tripID) {
		this.tripID = tripID;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getFinishedDate() {
		return finishedDate;
	}

	public void setFinishedDate(Timestamp finishedDate) {
		this.finishedDate = finishedDate;
	}

	public int getReasonID() {
		return reasonID;
	}

	public void setReasonID(int reasonID) {
		this.reasonID = reasonID;
	}

	public Timestamp getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(Timestamp startedDate) {
		this.startedDate = startedDate;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public int getTransporterOrderID() {
		return transporterOrderID;
	}

	public void setTransporterOrderID(int transporterOrderID) {
		this.transporterOrderID = transporterOrderID;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User TUser1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public User getUser3() {
		return this.user3;
	}

	public void setTUser3(User user3) {
		this.user3 = user3;
	}

	/*
	 * public List<EpodAttachment> getEpodAttachments() { return
	 * this.ePodAttachments; }
	 * 
	 * public void setEpodAttachments(List<EpodAttachment> ePodAttachments) {
	 * this.ePodAttachments = ePodAttachments; }
	 */

	/*
	 * public EpodAttachment addEpodAttachment(EpodAttachment ePodAttachments) {
	 * getEpodAttachments().add(ePodAttachments); ePodAttachments.setTrip(this);
	 * return ePodAttachments; }
	 * 
	 * public EpodAttachment removeEpodAttachment(EpodAttachment ePodAttachments) {
	 * getEpodAttachments().remove(ePodAttachments); ePodAttachments.setTrip(null);
	 * return ePodAttachments; }
	 */
}