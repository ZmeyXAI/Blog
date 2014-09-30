package com.comspicuum.mvc.domain;

import java.io.*;
import java.sql.Date;
import java.util.*;

public class Contact implements Serializable {
	private long id;
	private String firstName;
	private String lastName;
	private Date birhtDate;
	private List<ContactTelDetail> ContactTelDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirhtDate() {
		return birhtDate;
	}

	public void setBirhtDate(Date birhtDate) {
		this.birhtDate = birhtDate;
	}

	public List<ContactTelDetail> getContactTelDetails() {
		return ContactTelDetails;
	}

	public void setContactTelDetails(List<ContactTelDetail> contactTelDetails) {
		ContactTelDetails = contactTelDetails;
	}

	@Override
	public String toString() {
		return "Contact{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birhtDate=" + birhtDate +
				", ContactTelDetails=" + ContactTelDetails +
				'}';
	}
}
