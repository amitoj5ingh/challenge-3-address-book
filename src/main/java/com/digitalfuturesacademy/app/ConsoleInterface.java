package com.digitalfuturesacademy.app;

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
                // editContact
                handleConsole();
                break;
            case 3:
                // removeContact
                handleConsole();
                break;
            case 4:
                // viewContacts
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

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        ConsoleInterface consoleInterface = new ConsoleInterface(addressBook, scanner);

        consoleInterface.handleConsole();

        scanner.close();
    }


}
