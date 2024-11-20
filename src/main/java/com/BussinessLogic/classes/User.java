package com.BussinessLogic.classes;

import java.util.List;

public abstract class User {
    private int ID;
    private String username;
    private String firstname;
    private String lastname;
    private String address;
    private String password;
    private String dob;
    
    public User(int ID, String username, String firstname, String lastname, String address, String dob, String password) {
        this.ID = ID;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.password = password;
        this.address=address;
    }

    public User(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

}
