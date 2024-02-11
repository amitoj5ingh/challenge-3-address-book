package com.digitalfuturesacademy.app;

import java.util.ArrayList;

public class AddressBook {

    ArrayList<Contact> contacts = new ArrayList<>();

    public AddressBook() {}

    public void addContact(Contact contact) {
        if(contact.getName() == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(doesNumberExist(contact.getNumber())) {
            throw new IllegalArgumentException("Number already exists");
        }
        if(doesEmailExist(contact.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        this.contacts.add(contact);
    }

    public boolean doesNumberExist(String number) {
        for(Contact contact : contacts) {
            if(contact.getNumber().equals(number)) {
                return true;
            }
        }
        return false;
    }

    public boolean doesEmailExist(String email) {
        for(Contact contact : contacts) {
            if(contact.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
