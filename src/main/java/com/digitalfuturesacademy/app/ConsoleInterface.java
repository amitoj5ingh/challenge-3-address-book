package com.digitalfuturesacademy.app;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInterface {
    private AddressBook addressBook;
    private Scanner scanner;
    private Boolean running = true;

    public ConsoleInterface(AddressBook addressBook, Scanner scanner) {
        this.addressBook = addressBook;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("1. Add contact");
        System.out.println("2. Edit contact");
        System.out.println("3. Delete contact");
        System.out.println("4. View all contacts");
        System.out.println("5. Search contacts");
        System.out.println("6. Exit");
    }

    public void handleUserInput(int choice) {
        switch (choice) {
            case 1:
                handleAddContact();
                handleConsole();
                break;
            case 2:
                handleEditContact();
                handleConsole();
                break;
            case 3:
                handleRemoveContact();
                handleConsole();
                break;
            case 4:
                handleViewContacts();
                handleConsole();
                break;
            case 5:
                handleSearchContacts();
                handleConsole();
                break;
            case 6:
                running = false;
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void handleConsole() {
        if (!running) {
            System.exit(0);
        }
        showMenu();
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        handleUserInput(choice);
    }

    public void handleAddContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact email: ");
        String email = scanner.nextLine();
        System.out.println("Enter contact phone: ");
        String phone = scanner.nextLine();
        Contact contact = new Contact(name, email, phone);
        addressBook.addContact(contact);
    }

    public void handleSearchContacts() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        Contact contact = addressBook.searchByName(name);
        if (contact != null) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("Phone: " + contact.getNumber());
        } else {
            System.out.println("Contact not found");
        }
    }

    public void handleRemoveContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        addressBook.removeContact(name);
    }

    public void handleEditContact() {
        System.out.println("Enter current contact name: ");
        String oldName = scanner.nextLine();
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new contact email: ");
        String email = scanner.nextLine();
        System.out.println("Enter new contact phone: ");
        String phone = scanner.nextLine();
        Contact contact = addressBook.searchByName(oldName);
        ContactEditor.editContact(addressBook, contact, name, email, phone);
    }

    public void handleViewContacts() {
        ArrayList<Contact> contacts = addressBook.viewContacts();
        int x = 1;
        for (Contact contact : contacts) {
            System.out.println(x + ". ");
            System.out.println("Name: " + contact.getName());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("Phone: " + contact.getNumber());
            x++;
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        ConsoleInterface consoleInterface = new ConsoleInterface(addressBook, scanner);

        consoleInterface.handleConsole();

        scanner.close();
    }


}
