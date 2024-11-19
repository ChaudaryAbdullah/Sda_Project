package com.classes;

import java.util.List;

public abstract class User {
    private String ID;
    private String username;
    private String firstname;
    private String lastname;
    private String address;
    private String password;
    private String dob;
    
    public User(String ID, String username, String firstname, String lastname, String address, String dob, String password) {
        this.ID = ID;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.password = password;
        this.address=address;
    }

    public void displayRentals() {
   
    }

}
