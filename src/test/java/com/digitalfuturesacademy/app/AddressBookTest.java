package com.digitalfuturesacademy.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookTest {

    @Nested
    @DisplayName("AddressBook addContact tests")
    class AddressBookAddContactTests {
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

        // Gen AI has been used to help write the following
        @Test
        @DisplayName("Test addContact throws IllegalArgumentException when the duplicate email has different case")
        void testAddContactThrowsIllegalArgumentExceptionWhenDuplicateEmailHasDifferentCase() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("Example Person");
            when(contact.getEmail()).thenReturn("example@email.com");
            when(contact.getNumber()).thenReturn("07123456789");
            Contact duplicateContact = mock(Contact.class);
            when(duplicateContact.getName()).thenReturn("Example Person 2");
            when(duplicateContact.getEmail()).thenReturn("Example@email.com");
            when(duplicateContact.getNumber()).thenReturn("07123456789");

            // Act
            addressBook.addContact(contact);

            // Assert
            assertThrows(IllegalArgumentException.class, () -> {
                addressBook.addContact(duplicateContact);
            });
        }
    }

    @Nested
    @DisplayName("AddressBook searchByName tests")
    class AddressBookSearchByNameTests {
        @Test
        @DisplayName("Test searchByName returns corresponding contact when name exists")
        void testSearchByNameReturnsContactWhenNameExists() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("Example Person");
            when(contact.getEmail()).thenReturn("example@email.com");
            when(contact.getNumber()).thenReturn("07123456789");
            addressBook.addContact(contact);

            // Act
            // Assert
            assertEquals(contact, addressBook.searchByName("Example Person"));
        }

        @Test
        @DisplayName("Test searchByName returns null when name does not exist")
        void testSearchByNameReturnsNullWhenNameDoesNotExist() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("Example Person");
            when(contact.getEmail()).thenReturn("example@email.com");
            when(contact.getNumber()).thenReturn("07123456789");
            addressBook.addContact(contact);

            // Act
            // Assert
            assertEquals(null, addressBook.searchByName("New Person"));
        }

        @Test
        @DisplayName("Test searchByName returns null when contacts array is empty")
        void testSearchByNameReturnsNullWhenContactsArrayIsEmpty() {
            // Arrange
            AddressBook addressBook = new AddressBook();

            // Act
            // Assert
            assertEquals(null, addressBook.searchByName("New Person"));
        }
    }

    @Nested
    @DisplayName("AddressBook removeContact tests")
    class AddressBookRemoveContactTests {
        @Test
        @DisplayName("Test contacts array length decreases by 1 when removeContact is called")
        void testNameArrayLengthDecreased() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("Example Person");
            when(contact.getEmail()).thenReturn("example@email.com");
            when(contact.getNumber()).thenReturn("07123456789");
            addressBook.addContact(contact);

            // Act
            addressBook.removeContact("Example Person");

            // Assert
            assertEquals(0, addressBook.contacts.size());
        }

        @Test
        @DisplayName("Test contact removed by removeContact is no longer in contacts array")
        void testContactRemovedIsNotInArray() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("Example Person");
            when(contact.getEmail()).thenReturn("example@email.com");
            when(contact.getNumber()).thenReturn("07123456789");
            addressBook.addContact(contact);

            // Act
            addressBook.removeContact("Example Person");

            // Assert
            assertEquals(null, addressBook.searchByName("Example Person"));
        }
    }

    @Nested
    @DisplayName("AddressBook viewContacts tests")
    class AddressBookViewContactsTests {
        @Test
        @DisplayName("Test viewContacts returns contacts array")
        void testViewContactsReturnsContactsArray() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("Example Person");
            when(contact.getEmail()).thenReturn("example@email.com");
            when(contact.getNumber()).thenReturn("07123456789");
            addressBook.addContact(contact);
            Contact contact2 = mock(Contact.class);
            when(contact2.getName()).thenReturn("Example Person 2");
            when(contact2.getEmail()).thenReturn("example2@email.com");
            when(contact2.getNumber()).thenReturn("07987654321");
            addressBook.addContact(contact2);

            // Act
            // Assert
            assertEquals(addressBook.contacts, addressBook.viewContacts());
        }

        @Test
        @DisplayName("Test viewContacts returns empty array when contacts array is empty")
        void testViewContactsReturnsEmptyArrayWhenContactsArrayIsEmpty() {
            // Arrange
            AddressBook addressBook = new AddressBook();

            // Act
            // Assert
            assertEquals(0, addressBook.viewContacts().size());
        }
    }
}
