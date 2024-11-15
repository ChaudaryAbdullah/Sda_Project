package com.example;
public class MaintenanceRequest {
    private String requestID;
    private String description;
    private String status;
    private String requestDate;
    private String completionDate;

    public MaintenanceRequest(String requestID, String description, String status, String requestDate, String completionDate) {
        this.requestID = requestID;
        this.description = description;
        this.status = status;
        this.requestDate = requestDate;
        this.completionDate = completionDate;
    }

    public void createRequest(String description, String requestDate) {
    }

    public void updateStatus(String newStatus) {
    }
}
