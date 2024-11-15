package com.classes;

import java.util.List;

public class Applicant {
    private String applicantID;
    private String name;
    private String contactInfo;
    private String applicationStatus;
    private String applicationDate;
    private String preferences;

    private List<Notification> notifications;

    public Applicant(String applicantID, String name, String contactInfo, String applicationStatus, String applicationDate, String preferences) {
        this.applicantID = applicantID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.applicationStatus = applicationStatus;
        this.applicationDate = applicationDate;
        this.preferences = preferences;
    }

    public void displayRentals() {
   
    }

    public void applyForRental(String rentalID) {
    }
}