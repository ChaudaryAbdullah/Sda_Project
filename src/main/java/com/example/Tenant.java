package com.example;

import java.util.List;

public class Tenant {
    private String tenantID;
    private String name;
    private String roomNumber;
    private double rentAmount;
    private String paymentStatus;
    private double fines;
    private String moveInDate;
    private String preferences;

    private Rent rent;
    private List<MaintenanceRequest> maintenanceRequests;
    private List<Feedback> feedbacks;
    private Notification notification;

    public Tenant(String tenantID, String name, String roomNumber, double rentAmount, String paymentStatus, double fines, String moveInDate, String preferences) {
        this.tenantID = tenantID;
        this.name = name;
        this.roomNumber = roomNumber;
        this.rentAmount = rentAmount;
        this.paymentStatus = paymentStatus;
        this.fines = fines;
        this.moveInDate = moveInDate;
        this.preferences = preferences;
    }

    
    public void appealEviction(String evictionID) {
        
    }

    public void requestParkingSpot() {
    
    }

    public void chooseMenu(String menuID) {
      
    }

    public double viewOutstandingBalance() {
       
        return 0.0;
    }

    public void provideFeedback(String rentalID, String feedbackText, int rating) {
      
    }

    public void followRental(String rentalID) {
       
    }

    public void viewDueNotification() {
    
    }
}
