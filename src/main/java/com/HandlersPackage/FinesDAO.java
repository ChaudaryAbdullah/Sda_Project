package com.HandlersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.BussinessLogic.DB.jdbc;

public class FinesDAO {
    private final jdbc javaJdbc;

    FinesDAO(){
        this.javaJdbc = new jdbc();
    }

    public boolean addFine(String todayDate, String reasonString, int fineAmount, int ownerId, int tenantId){
        jdbc javaJdbc=new jdbc();
        String query = "INSERT INTO fine (issueDate, reason, amount, ownerId, tenantId) \r\n" + //
                        "VALUES (?, ?, ?, ?, ?)";
        boolean isInserted = false;
        String tenantID = String.valueOf(tenantId);
        String ownerIdString = String.valueOf(ownerId);
        String fine = String.valueOf(fineAmount);

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            javaJdbc.insertFineInDatabase(preparedStatement, todayDate, reasonString, fine, ownerIdString, tenantID);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }        

        return isInserted;
    }
    
}
