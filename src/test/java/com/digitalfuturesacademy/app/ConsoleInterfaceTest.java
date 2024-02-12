package com.digitalfuturesacademy.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Test handleUserInput calls addContact when 1 is entered and user input is entered")
    void testHandleUserInputCallsAddContact() {
        // Arrange
        AddressBook addressBook = mock(AddressBook.class);
        ConsoleInterface consoleInterface = new ConsoleInterface(addressBook, scanner);
        String input = "Example Person\r\nexample@email.com\r\n07123456789\r\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        Contact contact = mock(Contact.class);
        when(contact.getName()).thenReturn("Example Person");
        when(contact.getEmail()).thenReturn("example@email.com");
        when(contact.getNumber()).thenReturn("07123456789");

        // Act
        consoleInterface.handleUserInput(1);

        // Assert
        verify(addressBook).addContact(contact);


    }

}
