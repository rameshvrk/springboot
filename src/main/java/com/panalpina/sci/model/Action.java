package com.panalpina.sci.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_Action database table.
 * 
 */
@Entity
@Table(name="t_Action")
@NamedQuery(name="Action.findAll", query="SELECT t FROM Action t")
public class Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Action_ID")
	private int actionId;

	@Column(name="Description")
	private String description;

	@Column(name="Email_Format_ID")
	private int emailFormatId;

	@Column(name="Status_ID")
	private int statusId;

	public Action() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public int getEmailFormatId() {
		return emailFormatId;
	}

	public void setEmailFormatId(int emailFormatId) {
		this.emailFormatId = emailFormatId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

}