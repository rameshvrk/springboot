package com.panalpina.sci.dto;

public class Message {

	private String status;
	private String message;
	private String errorCode;

	public Message(String status, String msg) {
		this.message = msg;
		this.status = status;
	}

	public Message(String status, String msg, String errorCode) {
		this.message = msg;
		this.status = status;
		this.errorCode = errorCode;
	}

	public Message() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
