package com.BussinessLogic.classes;

public class Tenant extends User{

    public Tenant(int ID, String username, String firstname, String lastname, String address, String dob, String password) {
        super(ID, username, firstname, lastname, address, dob, password);
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
