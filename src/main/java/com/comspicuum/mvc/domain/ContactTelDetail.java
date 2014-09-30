package com.comspicuum.mvc.domain;

import java.io.*;

public class ContactTelDetail implements Serializable {
	private  Long id;
	private  Long contactId;
	private String telType;
	private String telNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getTelType() {
		return telType;
	}

	public void setTelType(String telType) {
		this.telType = telType;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	
	public String toString (){
		return "Contact tel detail - Id: " + getId() + ", Contact Id: " + getContactId() + 
				", Type: " + getTelType() + ", Number: " + getTelNumber();
	}
}
