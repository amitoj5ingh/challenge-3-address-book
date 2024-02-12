package com.digitalfuturesacademy.app;

public class ContactEditor {
    public static void editContact(AddressBook addressBook, Contact contact, String name, String email, String phone) {
        if (addressBook.doesNumberExist(phone)) {
            return;
        }
        if (addressBook.doesEmailExist(email)) {
            return;
        }
        if (name != null) {
            contact.setName(name);
            contact.setEmail(email);
            contact.setNumber(phone);
        }
    }

}
