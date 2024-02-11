package com.digitalfuturesacademy.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookTest {

    @Test
    @DisplayName("Test contacts array length increases by 1 when addContact is called")
    void testNameArrayLengthIncreased() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contact contact = mock(Contact.class);
        when(contact.getName()).thenReturn("Example Person");
        when(contact.getEmail()).thenReturn("example@email.com");
        when(contact.getNumber()).thenReturn("07123456789");

        // Act
        addressBook.addContact(contact);

        // Assert
        assertEquals(1, addressBook.contacts.size());
    }

    @Test
    @DisplayName("Test last element of contacts array is the contact added")
    void testLastArrayElementIsContact() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contact contact = mock(Contact.class);
        when(contact.getName()).thenReturn("Example Person");
        when(contact.getEmail()).thenReturn("example@email.com");
        when(contact.getNumber()).thenReturn("07123456789");

        // Act
        addressBook.addContact(contact);

        // Assert
        assertEquals(contact, addressBook.contacts.get(addressBook.contacts.size() - 1));
    }

    @Test
    @DisplayName("Test addContact throws IllegalArgumentException when the contact name is null")
    void testAddContactThrowsIllegalArgumentExceptionWhenNameIsNull() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contact contact = mock(Contact.class);
        when(contact.getName()).thenReturn(null);
        when(contact.getEmail()).thenReturn("example@email.com");
        when(contact.getNumber()).thenReturn("07123456789");

        // Act
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            addressBook.addContact(contact);
        });
    }

    @Test
    @DisplayName("Test addContact throws IllegalArgumentException when the number already exists")
    void testAddContactThrowsIllegalArgumentExceptionWhenNumberExists() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contact contact = mock(Contact.class);
        when(contact.getName()).thenReturn("Example Person");
        when(contact.getEmail()).thenReturn("example@email.com");
        when(contact.getNumber()).thenReturn("07123456789");
        Contact duplicateContact = mock(Contact.class);
        when(duplicateContact.getName()).thenReturn("Example Person");
        when(duplicateContact.getEmail()).thenReturn("example@email.com");
        when(duplicateContact.getNumber()).thenReturn("07123456789");

        // Act
        addressBook.addContact(contact);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            addressBook.addContact(duplicateContact);
        });
    }

    @Test
    @DisplayName("Test addContact throws IllegalArgumentException when the email already exists")
    void testAddContactThrowsIllegalArgumentExceptionWhenEmailExists() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Contact contact = mock(Contact.class);
        when(contact.getName()).thenReturn("Example Person");
        when(contact.getEmail()).thenReturn("example@email.com");
        when(contact.getNumber()).thenReturn("07123456789");
        Contact duplicateContact = mock(Contact.class);
        when(duplicateContact.getName()).thenReturn("Example Person");
        when(duplicateContact.getEmail()).thenReturn("example@email.com");
        when(duplicateContact.getNumber()).thenReturn("07987654321");

        // Act
        addressBook.addContact(contact);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            addressBook.addContact(duplicateContact);
        });
    }

}