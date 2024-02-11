package com.digitalfuturesacademy.app;

public class Contact {

    private String name;
    private String email;
    private String number;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.number = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }
}
