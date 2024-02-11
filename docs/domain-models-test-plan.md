# User Stories and Test Plan

---

## User story 1
As a user, I want to be able to add a contact to the address book, so that I can save that contact for the future.

## Tests
1. When addContact is called, the length of the contacts array should increase by 1.
2. When addContact is called, the last element of the contacts array should be the contact that was added.
3. The name of the contact is not null.
4. If the phone number already exists in the address book, the contact should not be added.
5. If the email already exists in the address book, the contact should not be added.

## User story 2
As a user, I want to be able to search for a contact by name, so that I can find the contact I am looking for.

## Tests
1. When searchByName is called, the contact with the corresponding name should be returned.
2. If the name passed to searchByName does not exist in the address book, null should be returned.
3. If contacts array is empty, null should be returned.

## User story 3
As a user, I want to be able to remove a contact from the address book, so that it won't save a contact that I don't need.

## User story 4
As a user, I want to be able to edit the details of a contact, so that I can keep the contact information up to date.

## User story 5
As a user, I want to be able to view a list of all the contacts in the address book, so that I can see all the contacts I have saved.

## User story 6
As a user, I want to be able to interact with the application using a console interface, so that I can use the different features of the application and see the results.