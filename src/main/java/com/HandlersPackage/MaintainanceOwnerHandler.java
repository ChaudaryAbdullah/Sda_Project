package com.HandlersPackage;

import com.BussinessLogic.classes.MaintenanceRequest;

import com.Factories.MaintainanceRequestsFactory;

public class MaintainanceOwnerHandler {
    private final MaintainanceDAO maintenanceRequestDAO;

    public MaintainanceOwnerHandler() {
        maintenanceRequestDAO = new MaintainanceDAO();
    }

    public void newMaintainance(String description, int rentalId, String todayDate) {
        MaintenanceRequest maintenanceRequest = MaintainanceRequestsFactory.createMaintenanceRequest(
                description, "0", todayDate, null, rentalId);

        maintenanceRequestDAO.insertMaintenanceRequest(maintenanceRequest);
    }

    public void updateMaintainance(int maintenanceId, boolean isComplete, String todayDate) {
        String status = isComplete ? "1" : "0";
        maintenanceRequestDAO.updateMaintenanceRequest(maintenanceId, status, todayDate);
    }
}
