package com.BussinessLogic.loadDataPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.BussinessLogic.DB.jdbc;

import javafx.scene.control.ComboBox;


public class LoadComboData {
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

    public ComboBox<String> loadRentalDataTenantComboBox(ComboBox<String> combo, int ID) {
        jdbc javaJdbc = new jdbc();
        String query = "SELECT rental.rentalId, rental.rentalName " +
               "FROM rental " +
               "JOIN rent ON rental.rentalId = rent.rentalId " +
               "JOIN tenant ON rent.tenantId = tenant.tenantId " +
               "WHERE tenant.tenantId = ?";

        
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

    public ComboBox<String> loadMaintainanceComboBox(ComboBox<String> combo, int ID) {
        jdbc javaJdbc = new jdbc();
        String query = "SELECT maintainance.maintananceId, maintainance.description FROM maintainance JOIN rental ON maintainance.rentalId = rental.rentalId JOIN owns ON rental.rentalId = owns.rentalId WHERE owns.ownerId = ?;";

        
        try (Connection conn = javaJdbc.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query, 
                 ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            
            // Directly populate the ComboBox
            while (rs.next()) {
                combo.getItems().add(rs.getString("maintananceId") + " " + rs.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return combo;
    }

    public ComboBox<String> loadApplicantsComboBox(ComboBox<String> combo, int ID) {
        jdbc javaJdbc = new jdbc();
        String query = "SELECT a.applicantId, a.firstName, a.lastName, ar.rentalId, ar.roomId\n" + //
                        "FROM owns o JOIN applyRental ar \n" + //
                        "ON o.rentalId = ar.rentalId\n" + //
                        "JOIN applicant a \n" + //
                        "ON ar.applicantId = a.applicantId\n" + //
                        "WHERE o.ownerId = ?";

        
        try (Connection conn = javaJdbc.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query, 
                 ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            
            // Directly populate the ComboBox
            while (rs.next()) {
                combo.getItems().add(rs.getString("applicantId") + " " + rs.getString("firstName") + " " + rs.getString("lastName")+ " " + rs.getString("rentalId")+ " " + rs.getString("roomId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return combo;
    }

    public ComboBox<String> loadNULLRents(ComboBox<String> combo, int ID){
        jdbc javaJdbc = new jdbc();
        String query = "SELECT r.tenantId, r.rentalId FROM rent r JOIN owns o ON r.rentalId = o.rentalId WHERE o.ownerId = ? AND r.roomId IS NULL";
        try (Connection conn = javaJdbc.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query, 
                 ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            
            // Directly populate the ComboBox
            while (rs.next()) {
                combo.getItems().add(rs.getString("tenantId") + " " + rs.getString("rentalId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return combo;
    }
    public ComboBox<String> loadRoomsData(ComboBox<String> combo, int RentalID){
        jdbc javaJdbc = new jdbc();
        String query = "SELECT roomId, rtype, status, descript, price FROM room WHERE rentalId = ? AND status = '0'";
        try (Connection conn = javaJdbc.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query, 
                 ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            
            preparedStatement.setInt(1, RentalID);
            ResultSet rs = preparedStatement.executeQuery();
            
            // Directly populate the ComboBox
            while (rs.next()) {
                combo.getItems().add(rs.getString("roomId") + " " + rs.getString("price") + " " + rs.getString("descript"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return combo;
    }
    public int getRoomPrice(int roomId){
        jdbc javaJdbc = new jdbc();
        int price=0;;
        String query = "SELECT price FROM room WHERE roomId = ? ";
        try (Connection conn = javaJdbc.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query, 
                 ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            
            preparedStatement.setInt(1, roomId);
            ResultSet rs = preparedStatement.executeQuery();
            
            // Directly populate the ComboBox
            while (rs.next()) {
                price = rs.getInt("roomId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return price;
    }
}
