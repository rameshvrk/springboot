package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_ePOD_Attachments database table.
 * 
 */
@Entity
@Table(name="t_ePOD_Attachments")
@NamedQuery(name="EpodAttachment.findAll", query="SELECT t FROM EpodAttachment t")
public class EpodAttachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Attachment_ID")
	private int attachmentID;

	@Column(name="Attachment_Name")
	private String attachmentName;

	@Column(name="Comments")
	private String comments;

	@Column(name="Created_Date")
	private Timestamp createdDate;

	//bi-directional many-to-one association to T_Transport_Order
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Transport_Order_ID")
	private TransportOrder transportOrder;

/*	//bi-directional many-to-one association to T_Trip
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Trip_ID")
	private Trip trip;
*/
	//bi-directional many-to-one association to T_User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Created_By")
	private User user;

	public EpodAttachment() {
	}

	

	public int getAttachmentID() {
		return attachmentID;
	}



	public void setAttachmentID(int attachmentID) {
		this.attachmentID = attachmentID;
	}



	public String getAttachmentName() {
		return attachmentName;
	}



	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}



	public Timestamp getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}



	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	

	public TransportOrder getTransportOrder() {
		return this.transportOrder;
	}

	public void setTransportOrder(TransportOrder transportOrder) {
		this.transportOrder = transportOrder;
	}

/*	public Trip getTrip() {
		return this.trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}*/

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}