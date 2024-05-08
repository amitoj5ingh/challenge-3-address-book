package com.digitalfuturesacademy.app;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ConsoleInterfaceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Scanner scanner;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        scanner = new Scanner(System.in);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        scanner.close();
    }

    @Test
    @DisplayName("Test menu is displayed when showMenu is called")
    void testShowMenuDisplaysMenu() {
        // Arrange
        AddressBook addressBook = mock(AddressBook.class);
        ConsoleInterface consoleInterface = new ConsoleInterface(addressBook, scanner);

        // Act
        consoleInterface.showMenu();

        // Assert
        String expectedOutput = "1. Add contact\n2. Edit contact\n3. Delete contact\n4. View all contacts\n5. Search contacts\n6. Exit\n";
        expectedOutput = expectedOutput.replaceAll("\n", "\r\n");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Nested
    @DisplayName("handleAddContact tests")
    class HandleAddContactTests {
        @Test
        @DisplayName("Test handleConsole calls handleUserInput with the correct input")
        void testHandleConsoleCallsHandleUserInput() {
            // Arrange
            AddressBook addressBook = mock(AddressBook.class);
            String input = "1\r\nExample Person\r\nexample@email.com\r\n07123456789\r\n6\r\n";
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
            ConsoleInterface consoleInterface = new ConsoleInterface(addressBook, scanner);

            // Act
            consoleInterface.handleConsole();

            // Assert
            verify(addressBook).addContact(any(Contact.class));
        }

        @Test
        @DisplayName("Test handleUserInput calls handleAddContact when 1 is entered")
        void testHandleUserInputCallsAddContact() {
            // Arrange
            AddressBook addressBook = mock(AddressBook.class);
            String input = "Example Person\r\nexample@email.com\r\n07123456789\r\n6\n";
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);
            ConsoleInterface consoleInterface = new ConsoleInterface(addressBook, scanner);
            Contact contact = new Contact("Example Person", "example@email.com", "07123456789");

            // Act
            consoleInterface.handleUserInput(1);

            // Assert
            verify(addressBook).addContact(any(Contact.class));
        }
    }

    @Nested
    @DisplayName("handleSearchContact tests")
    class HandleSearchContactTests {
        @Test
        @DisplayName("Test handleUserInput calls handleSearchContacts with the correct input")
        void testHandleUserInputCallsHandleSearchContacts() {
            // Arrange
            AddressBook addressBook = mock(AddressBook.class);
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("Example Person");
            when(contact.getEmail()).thenReturn("example@email.com");
            when(contact.getNumber()).thenReturn("07123456789");
            addressBook.addContact(contact);
            String input = "Example Person\r\n6\r\n";
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
            ConsoleInterface consoleInterface = new ConsoleInterface(addressBook, scanner);

            // Act
            consoleInterface.handleUserInput(5);

            // Assert
            verify(addressBook).searchByName("Example Person");
        }
    }

    @Nested
    @DisplayName("handleRemoveContact tests")
    class HandleRemoveContactTests {
        @Test
        @DisplayName("Test handleUserInput calls handleRemoveContact with the correct input")
        void testHandleUserInputCallsHandleRemoveContact() {
            // Arrange
            AddressBook addressBook = mock(AddressBook.class);
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("Example Person");
            when(contact.getEmail()).thenReturn("example@email.com");
            when(contact.getNumber()).thenReturn("07123456789");
            addressBook.addContact(contact);
            String input = "Example Person\r\n6\r\n";
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
            ConsoleInterface consoleInterface = new ConsoleInterface(addressBook, scanner);

            // Act
            consoleInterface.handleUserInput(3);

            // Assert
            verify(addressBook).removeContact("Example Person");
        }
    }

    @Nested
    @DisplayName("handleEditContact tests")
    class HandleEditContactTests {
        @Test
        @DisplayName("Test handleUserInput calls handleEditContact with the correct input")
        void testHandleUserInputCallsHandleEditContact() {
            // Arrange
            AddressBook addressBook = mock(AddressBook.class);
            Contact contact = mock(Contact.class);
            when(contact.getName()).thenReturn("Example Person");
            when(contact.getEmail()).thenReturn("example@email.com");
            when(contact.getNumber()).thenReturn("07123456789");
            String input = "Example Person\r\nNew Person\r\nnew@email.com\r\n07987654321\r\n6\r\n";
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
            when(addressBook.searchByName("Example Person")).thenReturn(contact);
            doNothing().when(contact).setName(anyString());
            doNothing().when(contact).setEmail(anyString());
            doNothing().when(contact).setNumber(anyString());

            ConsoleInterface consoleInterface = new ConsoleInterface(addressBook, scanner);

            // Act
            consoleInterface.handleUserInput(2);

            // Assert
            verify(addressBook).searchByName("Example Person");
        }
    }

}
