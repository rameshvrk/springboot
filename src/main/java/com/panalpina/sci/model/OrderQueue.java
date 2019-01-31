package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_Order_Queue database table.
 * 
 */
@Entity
@Table(name="t_Order_Queue")
@NamedQuery(name="OrderQueue.findAll", query="SELECT t FROM OrderQueue t")
public class OrderQueue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Queue_ID", unique=true, nullable=false)
	private int queueID;

	@Column(name="Created_By", length=50)
	private String createdBy;

	@Column(name="Created_Date")
	private Timestamp createdDate;

	@Column(name="File_Name", nullable=false, length=255)
	private String fileName;

	@Column(name="Status", length=50)
	private String status;

	public OrderQueue() {
	}

	public int getQueueID() {
		return queueID;
	}

	public void setQueueID(int queueID) {
		this.queueID = queueID;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}