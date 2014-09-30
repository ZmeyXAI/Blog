package com.comspicuum.mvc.dao;

import com.comspicuum.mvc.domain.Contact;

import java.util.*;

public interface ContactDao {
	public List<Contact> findAll();

	public List<Contact> findByFirstName(String FirstName);

	public void insert(Contact contact);

	public void delete(Long contactId);

	public void update(Contact contact);
}
