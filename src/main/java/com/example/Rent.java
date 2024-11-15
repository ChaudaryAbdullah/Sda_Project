package com.example;

public class Rent {
    private String rentID;
    private double rentAmount;

    private Tenant tenant;

    public Rent(String rentID, double rentAmount) {
        this.rentID = rentID;
        this.rentAmount = rentAmount;
    }

   
    public double calculateRent(String tenantID) {
       
        return 0.0;
    }

    public void applyAdditionalCharges(String tenantID, double amount) {
      
    }

    public void applyDiscounts(String tenantID, double discount) {
     
    }
}
