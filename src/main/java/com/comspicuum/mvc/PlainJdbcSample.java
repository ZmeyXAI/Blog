package com.comspicuum.mvc;

import com.comspicuum.mvc.dao.ContactDao;
import com.comspicuum.mvc.domain.Contact;
import com.comspicuum.mvc.dao.plain.PlainContactDao;

import java.sql.Date;
import java.util.*;

/*
* Testing JDBC
*/
public class PlainJdbcSample {
	private  static ContactDao contactDao = new PlainContactDao();
	private  static void main(String[] args){
		System.out.println("Lisring initial contact date");
		listAllContacts();
		System.out.println();
		
		System.out.println("Insert a new contact");
		Contact contact =new Contact();
		contact.setFirstName("Alex");
		contact.setLastName("Gora");
		contact.setBirhtDate(
				new Date((new GregorianCalendar(1985,9,19)).getTime().getTime()));
		contactDao.insert(contact);
		listAllContacts();
		
	}
	private  static void listAllContacts(){
		List<Contact> contacts = contactDao.findAll();
		for (Contact contact:contacts){
			System.out.println(contact);
		}
	}
}
