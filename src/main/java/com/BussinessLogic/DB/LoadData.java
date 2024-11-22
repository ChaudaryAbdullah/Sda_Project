package com.BussinessLogic.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class LoadData {
    public TableView loadHomeData(TableView Table) {
        String query = "SELECT r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities, " +
                       "CONCAT(o.firstName, ' ', o.lastName) AS ownerName " +
                       "FROM rental r " +
                       "JOIN owns own ON r.rentalId = own.rentalId " +
                       "JOIN owner o ON own.ownerId = o.ownerId";
    
                       TableAssistant table= new TableAssistant();
                       return table.runZeroParameterquery(query, Table);
    }

    public TableView loadHomeNotificationData(TableView Table,int ID) {
        String query = "select n.dateTime,n.description from notification n\n" + //
                        "inner join sendnotificationtenant t on t.id = n.id\n" + //
                        "inner join sendnotificationowner o  on o.Id=n.id\n" + //
                        "where o.ownerId=? || t.tenantid=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    public TableView loadApproveApplicantData(TableView Table,int ID) {
        
        String query = "select a.userName, a.firstName, a.lastName, a.address, a.dob from applyRental rent \n" + //
                        "join applicant a on rent.applicantid=a.applicantId\n" + //
                        "join owns o on o.rentalId=rent.rentalId where o.ownerId=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }
    
    public TableView loadOwnerData(TableView Table,int ID) {
        String query = "select r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities from rental r \n" + //
                        "join owns on r.rentalId=owns.rentalId \n" + //
                        "where owns.ownerId=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    public TableView loadRenterData(TableView Table,int ID) {
        String query = "select room.rtype, room.descript,room.price, r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities from rental r \n" + //
                        "join rent on r.rentalId=rent.rentalId \n" + //
                        "join room on r.rentalId=room.rentalId \n" + //
                        "where rent.tenantId=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }
    
    public TableView loadMaintainanceData(TableView Table,int ID) {
        String query = "select m.description, r.rentalName,r.address,r.facilities from maintainance m\n" + //
                        "join rental r on m.rentalId=r.rentalId \n" + //
                        "join owns on owns.rentalId=m.rentalId\n" + //
                        "where m.status=0 and owns.ownerId=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    public TableView loadEvictionOwnerData(TableView Table,int ID) {
        String query = "select e.issueDate, e.evictionDate, e.reason, t.username, concat(t.firstname,' ',t.lastname)as FullName from eviction e \n" + //
                        "join tenant t on e.tenantId=t.tenantId \n" + //
                        "where ownerId=?";
    
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    public TableView loadFineOwnerData(TableView Table,int ID) {
        String query = "select t.username,t.firstname,t.lastName,t.dob, re.rentalName, room.rtype, room.descript, room.price from tenant t \n" + //
                        "join rent r on  r.tenantId=t.tenantId\n" + //
                        "join room on r.roomId=room.roomId\n" + //
                        "join rental re on re.rentalId=r.rentalId\n" + //
                        "join owns on re.rentalId=owns.rentalId\n" + //
                        "where ownerId=?";
                        
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    public TableView loadReviewFeedbackData(TableView Table,int ID) {
        String query = "select f.rating, f.description, r.rentalName, r.address, r.facilities from feedback f \n" + //
                        "inner join rental r on r.rentalId=f.rentalId\n" + //
                        "inner join owns o on o.rentalId=r.rentalId\n" + //
                        "where o.ownerId=?";
                        
                        TableAssistant table= new TableAssistant();
                        return table.runOneParameterquery(query, Table, ID);
    }

    public TableView loadAllocateParkingData(TableView Table,int ID) {
        String query = "select pr.slotId, t.firstName, t.lastName, t.username, r.rentalName,r.address from parkingrequest pr \n" + //
                        "join tenant t on pr.tenantId=t.tenantId\n" + //
                        "join parkingslot p on p.slotId=pr.slotId\n" + //
                        "join rental r on r.rentalId=p.rentalId\n" + //
                        "join owns o on o.rentalId=r.rentalId\n" + //
                        "where o.ownerId=?";
                        
        TableAssistant table= new TableAssistant();
        return table.runOneParameterquery(query, Table, ID);
        
    }

    public ComboBox<String> loadRentalDataComboBox(ComboBox<String> combo, int ID) {
        jdbc javaJdbc = new jdbc();
        String query = "select r.rentalId, r.rentalName from rental r " +
                       "join owns on r.rentalId = owns.rentalId " +
                       "where owns.ownerId = ?";
        
        try (Connection conn = javaJdbc.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query, 
                 ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            
            // Directly populate the ComboBox
            while (rs.next()) {
                combo.getItems().add(rs.getString("rentalId") + " " + rs.getString("rentalName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return combo;
    }

    public ComboBox<String> loadTenantDataComboBox(ComboBox<String> combo, int ID) {
        jdbc javaJdbc = new jdbc();
        String query =  "SELECT t.tenantId, t.userName, t.firstName, t.lastName, t.address, t.dob " + 
                        "FROM tenant t " +
                        "JOIN rent r ON t.tenantId = r.tenantId " +
                        "JOIN rental ren ON r.rentalId = ren.rentalId " +
                        "JOIN owns o ON ren.rentalId = o.rentalId " +
                        "WHERE o.ownerId = ?";
        
        try (Connection conn = javaJdbc.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query, 
                 ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("yankee");
            // Directly populate the ComboBox
            while (rs.next()) {
                combo.getItems().add(rs.getString("tenantId") + " " + rs.getString("firstName")+ " " + rs.getString("lastName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return combo;
    }


}
