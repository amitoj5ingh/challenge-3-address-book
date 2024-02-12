package com.digitalfuturesacademy.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ContactEditorTest {

    @Test
    @DisplayName("Test editContact has updated the contact details")
    void testEditContactUpdatesContact() {
        // Arrange
        Contact contact = new Contact("Example Person", "example@email.com", "07123456789");
        String newName = "New Name";
        String newEmail = "new@email.com";
        String newPhone = "07987654321";
        AddressBook addressBook = mock(AddressBook.class);

        // Act
        ContactEditor.editContact(addressBook, contact, newName, newEmail, newPhone);

        // Assert
        assertAll("Contact details updated",
                () -> assertEquals(newName, contact.getName()),
                () -> assertEquals(newEmail, contact.getEmail()),
                () -> assertEquals(newPhone, contact.getNumber()));

    }

    @Test
    @DisplayName("Test editContact doesn't change contact details when name is null")
    void testEditContactDoesNotEditWhenNameIsNull() {
        // Arrange
        Contact contact = new Contact("Example Person", "example@email.com", "07123456789");
        String newName = null;
        String newEmail = "new@email.com";
        String newPhone = "07987654321";
        AddressBook addressBook = mock(AddressBook.class);

        // Act
        ContactEditor.editContact(addressBook, contact, newName, newEmail, newPhone);

        // Assert
        assertAll("Contact details not updated",
                () -> assertEquals("Example Person", contact.getName()),
                () -> assertEquals("example@email.com", contact.getEmail()),
                () -> assertEquals("07123456789", contact.getNumber()));
    }

    @Test
    @DisplayName("Test editContact doesn't change contact details when phone number is a duplicate")
    void testEditContactDoesNotEditWhenPhoneIsDuplicate() {
        // Arrange
        Contact contact = new Contact("Example Person", "example@email.com", "07123456789");
        String newName = "New Name";
        String newEmail = "new@email.com";
        String newPhone = "07987654321";
        AddressBook addressBook = mock(AddressBook.class);
        when(addressBook.doesNumberExist(newPhone)).thenReturn(true);

        // Act
        ContactEditor.editContact(addressBook, contact, newName, newEmail, newPhone);

        // Assert
        assertAll("Contact details not updated",
                () -> assertEquals("Example Person", contact.getName()),
                () -> assertEquals("example@email.com", contact.getEmail()),
                () -> assertEquals("07123456789", contact.getNumber()));
    }

    @Test
    @DisplayName("Test editContact doesn't change contact details when email is a duplicate")
    void testEditContactDoesNotEditWhenEmailIsDuplicate() {
        // Arrange
        Contact contact = new Contact("Example Person", "example@email.com", "07123456789");
        String newName = "New Name";
        String newEmail = "new@email.com";
        String newPhone = "07987654321";
        AddressBook addressBook = mock(AddressBook.class);
        when(addressBook.doesEmailExist(newEmail)).thenReturn(true);

        // Act
        ContactEditor.editContact(addressBook, contact, newName, newEmail, newPhone);

        // Assert
        assertAll("Contact details not updated",
                () -> assertEquals("Example Person", contact.getName()),
                () -> assertEquals("example@email.com", contact.getEmail()),
                () -> assertEquals("07123456789", contact.getNumber()));
    }
}
