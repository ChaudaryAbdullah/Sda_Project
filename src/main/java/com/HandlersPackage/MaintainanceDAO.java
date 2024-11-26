package com.HandlersPackage;


import com.BussinessLogic.classes.MaintenanceRequest;
import com.BussinessLogic.DB.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaintainanceDAO {
    private final jdbc javaJdbc;

    public MaintainanceDAO() {
        this.javaJdbc = jdbc.getInstance(); // Singleton jdbc instance
    }

    public void insertMaintenanceRequest(MaintenanceRequest maintenanceRequest) {
        String query = "INSERT INTO maintainance (description, status, requestDate, rentalId) VALUES (?, ?, ?, ?)";

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, maintenanceRequest.getDescription());
            preparedStatement.setString(2, maintenanceRequest.getStatus());
            preparedStatement.setString(3, maintenanceRequest.getRequestDate());
            preparedStatement.setInt(4, maintenanceRequest.getRentalId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMaintenanceRequest(int maintenanceId, String status, String completionDate) {
        String query = "UPDATE maintainance SET status = ?, completionDate = ? WHERE maintananceId = ?";

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, status);
            preparedStatement.setString(2, completionDate);
            preparedStatement.setInt(3, maintenanceId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

