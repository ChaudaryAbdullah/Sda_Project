package com.Factories;

import com.BussinessLogic.classes.MaintenanceRequest;

public class MaintainanceRequestsFactory {
    private static String generateUniqueID() {
        return "REQ-" + System.currentTimeMillis();
    }
    public static MaintenanceRequest createMaintenanceRequest(String description, String status, String requestDate, String completionDate, int rentalId) {
        String requestID = generateUniqueID();
        return new MaintenanceRequest(requestID, description, status, requestDate, completionDate, rentalId);
    }   
}
