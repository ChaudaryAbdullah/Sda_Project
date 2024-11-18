package com.classes;

import java.util.List;

public class Applicant extends User {
  

    public Applicant(String applicantID, String name, String contactInfo, String applicationStatus, String applicationDate, String preferences) {
       super(applicantID, name, contactInfo, applicationStatus, applicationDate, preferences);
    }

    public void displayRentals() {
   
    }

    public void applyForRental(String rentalID) {
    }
}