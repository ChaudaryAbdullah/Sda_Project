package com.BussinessLogic.classes;

public class Payment {
    private String paymentID;
    private String method;
    private double total;

    public Payment(String paymentID, String method, double total) {
        this.paymentID = paymentID;
        this.method = method;
        this.total = total;
    }

 
    public void processPayment() {
      
    }
}
