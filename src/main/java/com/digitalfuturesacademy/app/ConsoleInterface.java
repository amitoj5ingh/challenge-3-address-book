package com.digitalfuturesacademy.app;

import java.util.Scanner;

public class ConsoleInterface {
    private AddressBook addressBook;
    private Contact contacta;
    private Scanner scanner;

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
                System.out.println("Enter contact name: ");
                String name = scanner.nextLine();
                System.out.println("Enter contact email: ");
                String email = scanner.nextLine();
                System.out.println("Enter contact phone: ");
                String phone = scanner.nextLine();
                Contact contact = new Contact(name, email, phone);
                addressBook.addContact(contact);
                break;
            case 2:
                ContactEditor.editContact(addressBook, contacta, "name", "email", "phone");
                break;
            case 3:
                addressBook.removeContact("name");
                break;
            case 4:
                addressBook.viewContacts();
                break;
            case 5:
                addressBook.searchByName("name");
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        ConsoleInterface consoleInterface = new ConsoleInterface(addressBook, scanner);

        consoleInterface.showMenu();
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        consoleInterface.handleUserInput(choice);

        scanner.close();
    }


}
