package com.BussinessLogic.classes;

public class Notification {
    private String date;
    private String time;
    private String text;

    private Applicant applicant;

    public Notification(String date, String time, String text) {
        this.date = date;
        this.time = time;
        this.text = text;
    }

   
    public void sendBookingConfirmation(String tenantID, String details) {
      
    }

    public void sendPaymentReceipt(String tenantID, String details) {
     
    }
}
