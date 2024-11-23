package com.Factories;

import com.BussinessLogic.classes.Fines;
import com.BussinessLogic.classes.MaintenanceRequest;

public class FinesFactory {
    private static String generateUniqueID() {
        return "REQ-" + System.currentTimeMillis();
    }
    public static Fines createFines(int fineId, String issueDate, String reason, int amount, int ownerId, int tenantId) {
        String requestID = generateUniqueID();
        return new Fines(fineId, issueDate, reason, amount, ownerId, tenantId);
    } 
}