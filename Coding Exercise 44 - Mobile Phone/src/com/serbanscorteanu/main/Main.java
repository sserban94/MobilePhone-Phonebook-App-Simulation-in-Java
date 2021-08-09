package com.serbanscorteanu.main;

import java.util.Scanner;

import com.serbanscorteanu.classes.Contact;
import com.serbanscorteanu.classes.MobilePhone;



public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone("07*******2");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Contact contact = new Contact("Bob", "31415926");
//		Contact contact2 = new Contact("Alice", "16180339");
//		Contact contact3 = new Contact("Tom", "11235813");
//		Contact contact4 = new Contact("Jane", "23571113");
//		
//		Contact contactSS = new Contact("Serban Scorteanu", "+407*******2");
//		Contact contactSSS = new Contact("Serban Scorteanu", "0040blabla");
//		mobilePhone.addNewContact(contact);
//		mobilePhone.addNewContact(contact2);
//		mobilePhone.addNewContact(contact3);
//		mobilePhone.addNewContact(contact4);
//		System.out.println(mobilePhone.addNewContact(contact3));
//		System.out.println(mobilePhone.addNewContact(contact4));
//		System.out.println(mobilePhone.addNewContact(contactSS));
//		System.out.println(mobilePhone.addNewContact(contactSS));
//		System.out.println(mobilePhone.addNewContact(contactSSS));
//		
//		mobilePhone.printContacts();
//		
//		mobilePhone.removeContact(contact2);
//		mobilePhone.printContacts();
//		
//		mobilePhone.queryContact("Bob");
//		mobilePhone.queryContact("Alice");
//		
//		mobilePhone.updateContact(contact, contactSS);
//		
//		mobilePhone.printContacts();

		boolean quit = false;
		startPhone();
		printActions();
		while (!quit) {
			System.out.println("\nEnter action: (6 to show available actions)");
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch (action) {
			case 0:
				System.out.println("\nShutting down..");
				quit = true;
				break;
			case 1:
				printContacts();
				break;
			case 2:
				addNewContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6:
				printActions();
				break;
			}
		}

	}

	private static void startPhone() {
		System.out.println("Starting phone..");
	}

	private static void printActions() {
		System.out.println("\nAvailable actions:\npress");
		System.out.println("0 - to shutdown\n" + 
						   "1 - to print contacts\n" + 
						   "2 - to add a new contact\n" + 
						   "3 - to update existing an existing contact\n" + 
						   "4 - to remove an existing contact\n" + 
						   "5 - query if an existing contact exists\n" + 
						   "6 - to print a list of available actions.");
		System.out.println("Choose your action");
	}
	
	private static void printContacts() {
		mobilePhone.printContacts();
	}
	
	private static void addNewContact() {
		System.out.println("Enter new contact name: ");
		String name = scanner.nextLine();
		System.out.println("Enter phone number: ");
		String phoneNumber = scanner.nextLine();
		Contact newContact = Contact.createContact(name, phoneNumber);
		if (mobilePhone.addNewContact(newContact)) {
			System.out.println("New contact added: " + name + ", phone = " + phoneNumber);
		} else {
			System.out.println("Cannot add, " + name + " already in phonebook");
		}
	}
	
	private static void updateContact() {
		System.out.println("Enter existing contact name: ");
		String name = scanner.nextLine();
		Contact existingContact = mobilePhone.queryContact(name);
		if (existingContact == null) {
			System.out.println("Not found");
			return;
		}
		System.out.println("Enter new contact name: ");
		String newName = scanner.nextLine();
		System.out.println("Enter new phone number: ");
		String newPhoneNumber = scanner.nextLine();
		Contact newContact = Contact.createContact(newName, newPhoneNumber);
		if (mobilePhone.updateContact(existingContact, newContact)) {
			System.out.println("Succes");
		} else {
			System.out.println("Error");
		}
	}
	
	private static void removeContact() {
		System.out.println("Enter existing contact name: ");
		String name = scanner.nextLine();
		Contact existingContact = mobilePhone.queryContact(name);
		if (existingContact == null) {
			System.out.println("Not found");
			return;
		}
		
		if (mobilePhone.removeContact(existingContact)) {
			System.out.println("Succes");
		} else {
			System.out.println("Error");
		}
	}
	
	private static void queryContact() {
		System.out.println("Enter existing contact name: ");
		String name = scanner.nextLine();
		Contact existingContact = mobilePhone.queryContact(name);
		if (existingContact == null) {
			System.out.println("Not found");
			return;
		}
		System.out.println("Name: " + existingContact.getName() + " phone number is " + existingContact.getPhoneNumber());
		
		if (mobilePhone.removeContact(existingContact)) {
			System.out.println("Succes");
		} else {
			System.out.println("Error");
		}
		
	}
	
	
	

}
