package com.BussinessLogic.classes;
import com.HandlersPackage.PaymentHandler;

public class Payment {
    private String paymentID;
    private String method;
    private double total;
    private boolean status;
    private int tenantID;

    PaymentHandler pay;


    public Payment(String paymentID, String method, double total, boolean status, int tenantID) {
        this.paymentID = paymentID;
        this.method = method;
        this.total = total;
        this.status = status;
        this.tenantID = tenantID;
    }

    public void calculateRent(){
        this.total = pay.calculateRent(this.tenantID);
    }

 
    public void processPayment() {
      
    }
    public String getPaymentID() {
        return paymentID;
    }

    public String getMethod() {
        return method;
    }

    public double getTotal() {
        return total;
    }

    public boolean isStatus() {
        return status;
    }

    public int getTenantID() {
        return tenantID;
    }

    // Setters
    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }
}
