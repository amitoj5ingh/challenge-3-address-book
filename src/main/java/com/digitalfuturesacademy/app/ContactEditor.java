package com.digitalfuturesacademy.app;

public class ContactEditor {
    public static void editContact(AddressBook addressBook, Contact contact, String name, String email, String phone) {
        if (isDuplicateContact(addressBook, email, phone)) {
            return;
        }
        updateContactDetails(contact, name, email, phone);
    }

    private static boolean isDuplicateContact(AddressBook addressBook, String email, String phone) {
        return addressBook.doesNumberExist(phone) || addressBook.doesEmailExist(email);
    }

    private static void updateContactDetails(Contact contact, String name, String email, String phone) {
        if (name != null) {
            contact.setName(name);
            contact.setEmail(email);
            contact.setNumber(phone);
        }
    }

}
