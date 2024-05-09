# User Stories and Test Plan

---

## User story 1
As a user, I want to be able to add a contact to the address book, so that I can save that contact for the future.

### Tests
1. When addContact is called, the length of the contacts array should increase by 1.
2. When addContact is called, the last element of the contacts array should be the contact that was added.
3. The name of the contact is not null.
4. If the phone number already exists in the address book, the contact should not be added.
5. If the email already exists in the address book, the contact should not be added.
6. If the email is a duplicate with different case, the contact should not be added.

## User story 2
As a user, I want to be able to search for a contact by name, so that I can find the contact I am looking for.

### Tests
1. When searchByName is called, the contact with the corresponding name should be returned.
2. If the name passed to searchByName does not exist in the address book, null should be returned.
3. If contacts array is empty, null should be returned.

## User story 3
As a user, I want to be able to remove a contact from the address book, so that it won't save a contact that I don't need.

### Tests
1. When removeContact is called, the length of the contacts array should decrease by 1.
2. When removeContact is called, the contact that was removed should no longer be in the contacts array.

## User story 4
As a user, I want to be able to edit the details of a contact, so that I can keep the contact information up to date.

### Tests
1. When editContact is called with a new name, the contact should be updated with the new details. 
2. If the name passed to editContact is null, the contact should not be updated. 
3. If the phone number passed to editContact already exists, the contact should not be updated. 
4. If the email passed to editContact already exists, the contact should not be updated.

## User story 5
As a user, I want to be able to view a list of all the contacts in the address book, so that I can see all the contacts I have saved.

### Tests
1. When viewContacts is called, the contacts array should be returned.
2. If the contacts array is empty, an empty array should be returned.

## User story 6
As a user, I want to be able to interact with the application using a console interface, so that I can use the different features of the application and see the results.

### Tests
1. When showMenu is called the menu should be printed to the console.
2. When the user selects add contact from the menu and enters the details of the contact, the addContact function should be called. 
3. When the user selects search for contact from the menu and enters the name, the searchByName function should be called. 
4. When the user selects remove contact from the menu, and enters the name, the removeContact function should be called. 
5. When the user selects edit contact from the menu and enters the details, the editContact function should be called. 
6. When the user selects view contacts from the menu, the viewContacts function should be called. 
7. When the handleViewContacts function is called, the contacts should be numbered and printed to the console.
8. When the searchByName function is called, the printContact function should be called with the contact that was returned.


---
# Additional Features
#### Generative AI has been used to help write the following user stories and domain models.
## User story 7
As a user I want to be able to search for a contact by phone number, so that I can find the contact I am looking for.

## Domain Model
| Object | Attributes | Messages | Outputs |
| --- | --- | --- | --- |
| AddressBook | contacts: Contact[] | searchByPhoneNumber(phoneNumber: string): Contact | Contact |

## User Story 8
As a user, I want to be able to search for a contact by email, so that I can find the contact I am looking for.

## Domain Model
| Object | Attributes | Messages | Outputs |
| --- | --- | --- | --- |
| AddressBook | contacts: Contact[] | searchByEmail(email: string): Contact | Contact |

## User Story 9
As a user, I want to be able to view a list of all the results of a search in alphabetical order, so that I can see all the contacts I have saved in a specific order.

## Domain Model
| Object | Attributes | Messages | Outputs |
| --- | --- | --- | --- |
| AddressBook | contacts: Contact[] | viewContactsAlphabetically(): Contact[] | Contact[] |

## User Story 10
As a user, I want to be able to delete all contacts from the address book, so that I can start fresh.

## Domain Model
| Object | Attributes | Messages | Outputs |
| --- | --- | --- | --- |
| AddressBook | contacts: Contact[] | deleteAllContacts(): void | void |