package com.HandlersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BussinessLogic.DB.LoadData;
import com.BussinessLogic.DB.TableAssistant;
import com.BussinessLogic.DB.jdbc;
import com.BussinessLogic.classes.Rental;
import com.BussinessLogic.classes.Tenant;
import com.BussinessLogic.classes.User;
import com.BussinessLogic.classes.parking;
import com.example.rentedController;
import com.BussinessLogic.classes.MaintenanceRequest;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import com.BussinessLogic.classes.MaintenanceRequest;
import com.HandlersPackage.MaintainanceDAO;
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
