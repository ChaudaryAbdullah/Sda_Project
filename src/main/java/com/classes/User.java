package com.classes;

import java.util.List;

public abstract class User {
    private String ID;
    private String name;
    private String contactInfo;
    private String applicationStatus;
    private String applicationDate;
    private String preferences;

    private List<Notification> notifications;

    public User(String applicantID, String name, String contactInfo, String applicationStatus, String applicationDate, String preferences) {
        this.ID = applicantID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.applicationStatus = applicationStatus;
        this.applicationDate = applicationDate;
        this.preferences = preferences;
    }

    public void displayRentals() {
   
    }

}
