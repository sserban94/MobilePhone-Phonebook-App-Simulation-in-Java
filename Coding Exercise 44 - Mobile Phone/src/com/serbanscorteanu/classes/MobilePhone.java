package com.serbanscorteanu.classes;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
	private String myNumber;
	private ArrayList<Contact> myContacts;

	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		myContacts = new ArrayList<>();
	}

	public boolean addNewContact(Contact contact) {
		if (findContact(contact.getName()) != -1) {
			return false;
		} else {
			myContacts.add(contact);
			return true;

		}
	}

	public boolean updateContact(Contact oldContact, Contact newContact) {
		if (findContact(oldContact) != -1) {
			myContacts.set(myContacts.indexOf(oldContact), newContact);
			return true;
		} else {
			return false;
		}
	}

	public boolean removeContact(Contact contact) {
		if (findContact(contact) != -1) {
			myContacts.remove(contact);
			return true;
		} else {
			return false;
		}
	}

	private int findContact(Contact contact) {
		return myContacts.indexOf(contact);
	}

	private int findContact(String name) {
		for (Contact contact : myContacts) {
			if (contact.getName().equals(name)) {
				return myContacts.indexOf(contact);
			}
		}
		return -1;
	}

	public Contact queryContact(String name) {
//		for (Contact contact : myContacts) {
//			if (contact.getName() == name) {
//				return contact;
//			}
//		}
		if (findContact(name) != -1) {
			return myContacts.get(findContact(name));
		} else {
			return null;
		}
	}
	
	public String queryContact(Contact contact) {
		if (findContact(contact) != -1) {
			return contact.getName();
		}
		return null;
	}

	public void printContacts() {
		System.out.println("Contact List:");
		int i = 1;
		for (Contact contact : myContacts) {
			System.out.println(i++ + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
		}
	}

}
