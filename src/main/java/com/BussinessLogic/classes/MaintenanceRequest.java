package com.BussinessLogic.classes;
public class MaintenanceRequest {
    private String requestID;
    private String description;
    private String status;
    private String requestDate;
    private String completionDate;
    private int rentalId;

    public MaintenanceRequest(String requestID, String description, String status, String requestDate, String completionDate, int rentalId) {
        this.requestID = requestID;
        this.description = description;
        this.status = status;
        this.requestDate = requestDate;
        this.completionDate = completionDate;
        this.rentalId = rentalId;
    }

    public void createRequest(String description, String requestDate) {
    }

    public void updateStatus(String newStatus) {
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter for requestDate
    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    // Getter and Setter for completionDate
    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public void setRentalId(int rentalId){
        this.rentalId = rentalId;
    }

    public int getRentalId(){
        return rentalId;
    }
    
}
