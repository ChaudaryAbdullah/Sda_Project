package com.BussinessLogic.DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.BussinessLogic.classes.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Utility {
    
    public User getUser(String user,String pass){

        
        String query = "SELECT * FROM owner WHERE username = ? && password = ?";
        jdbc javaJdbc=new jdbc();
        try (Connection connection = javaJdbc.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            if(javaJdbc.getUserFromDatabase(preparedStatement)!= null)
            {
              User user1 = javaJdbc.getUserFromDatabase(preparedStatement);
              connection.close();  
              return user1;
            }
            else{ 
                connection.close(); 
                return null;
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public boolean addUser(String userName, String firstName, String lastName, String dob, String pass, String address){
        
        jdbc javaJdbc=new jdbc();
        String query0 = "INSERT INTO owner (userName, firstName, lastName, address, dob, password) VALUES (?, ?, ?, ?, ?, ?)";
        String query1 = "INSERT INTO applicant (userName, firstName, lastName, address, dob, password) VALUES (?, ?, ?, ?, ?, ?)";
        String query2 = "INSERT INTO tenant (userName, firstName, lastName, address, dob, password) VALUES (?, ?, ?, ?, ?, ?)";
        boolean isInserted = false;
        List<String> queryList = new ArrayList<>();
        queryList.add(query0);
        queryList.add(query1);
        queryList.add(query2);

        for (String query : queryList) {
            try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            javaJdbc.insertUserInDatabase(preparedStatement, userName, firstName, lastName, dob, pass, address);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        return isInserted;
    }
    public void clearTextFields(Pane parentPane) {
        for (var node : parentPane.getChildren()) {
            if (node instanceof TextField) {
                ((TextField) node).clear();
            } else if (node instanceof Pane) {
                clearTextFields((Pane) node); // Recurse for nested panes
            }
        }
        System.out.println("All text fields have been cleared.");
    }

    public String getFormattedDateForMySQL(DatePicker selectDate) {
        // Retrieve the date from the DatePicker
        LocalDate date = selectDate.getValue();
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return date.format(formatter);
        }
        return "0000-00-00";
    }

    public String getTodayDate() {
        // Get today's date
        LocalDate today = LocalDate.now();

        // Define the format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Return the formatted date as a string
        return today.format(formatter);
    }

    public boolean addRental(String name, String address, String facilities, int Totalrooms, int availableRooms){
        jdbc javaJdbc=new jdbc();
        String query = "INSERT INTO rental (rentalName, address, facilities, totalRooms, availableRooms) VALUES (?, ?, ?, ?, ?)";
        boolean isInserted = false;
        String totalRoomsStr = String.valueOf(Totalrooms);
        String availableRoomsStr = String.valueOf(availableRooms);

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            javaJdbc.insertRentalInDatabase(preparedStatement, name, address, facilities, totalRoomsStr, availableRoomsStr);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }        

        return isInserted;
    }

    public boolean addRooms(int rentalId, String roomType, String descrip, int price, String imagePath){
        jdbc javaJdbc=new jdbc();
        String query = "INSERT INTO room (rtype, status, descript, price, rentalId, picture) VALUES (?, ?, ?, ?, ?, ?)";
        boolean isInserted = false;
        String rentalIdString = String.valueOf(rentalId);
        String priceString = String.valueOf(price);
        String roomStatus = "0";

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            javaJdbc.insertRoomInDatabase(preparedStatement, roomType, roomStatus, descrip, priceString, rentalIdString, imagePath);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }        

        return isInserted;
        
    }
    public HostelRental getRentalfromTenant(int ID){
        String rentalId = null;
        String query = "SELECT r.rentalId, r.rentalName, r.address, r.facilities, r.totalRooms, r.availableRooms " +
                       "FROM rental r " +
                       "JOIN owns o ON r.rentalId = o.rentalId " +
                       "JOIN rent ren ON o.rentalId = ren.rentalId " +
                       "WHERE ren.tenantId = ?";
        jdbc javaJdbc=new jdbc();
        String IdString = String.valueOf(ID);
        try (Connection connection = javaJdbc.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, IdString);

            if(javaJdbc.getRentalIdForTenant(preparedStatement)!= null)
            {
              HostelRental hos = javaJdbc.getRentalIdForTenant(preparedStatement);
              connection.close();  
              return hos;
            }
            else{ 
                connection.close(); 
                return null;
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addEviction(String todayDate, String evictionDate, int  tenantId, int ownerID, int  rentalid, String reason){
        jdbc javaJdbc=new jdbc();
        String query = "INSERT INTO eviction (issueDate, evictionDate, tenantId, ownerId, reason) \r\n" + //
                        "VALUES (?, ?, ?, ?, ?);";
        boolean isInserted = false;
        String rentalIdString = String.valueOf(rentalid);
        String tenantIdString = String.valueOf(tenantId);
        String ownerIDString = String.valueOf(ownerID);

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            javaJdbc.insertEvictionInDatabase(preparedStatement, todayDate, evictionDate, rentalIdString, tenantIdString, ownerIDString, reason);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }        

        return isInserted;
        
    }
    public boolean addNewMaintaince(String maintainceString, int rentalId, String todayDate){
        jdbc javaJdbc=new jdbc();
        String query = "INSERT INTO maintainance (description, status, requestDate, rentalId) VALUES (?, ?, ?, ?)";
        boolean isInserted = false;
        String rentalIdString = String.valueOf(rentalId);
        String description = String.valueOf(maintainceString);
        String date = String.valueOf(todayDate);
        String status = "0";
        String completion = " ";

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            javaJdbc.insertMaintainceInDatabase(preparedStatement, description, status, date, rentalIdString);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }        

        return isInserted;
    }
    public boolean UpdateMaintaince(Boolean status, int maintainceId, String todayDate){
        jdbc javaJdbc=new jdbc();
        String query = "UPDATE maintainance SET status = ?, completionDate = ? WHERE maintananceId = ?";
        boolean isInserted = false;
        String maintainceString = String.valueOf(maintainceId);

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            javaJdbc.UpdateMaintainceInDatabase(preparedStatement, status, todayDate, maintainceString);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }        

        return isInserted;
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
	public boolean addTenantRental(int tenantId, int rentalId){
        jdbc javaJdbc=new jdbc();
        String query = "INSERT INTO rent (tenantId, rentalId) VALUES (?, ?)";
        boolean isInserted = false;

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            javaJdbc.insertRentInDatabase(preparedStatement, tenantId, rentalId);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }        

        return isInserted;
    }

    public boolean deleteRent(int applicantId){
        jdbc javaJdbc=new jdbc();
        String query = "DELETE FROM applyRental WHERE applicantId = ?";
        boolean isInserted = false;

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            javaJdbc.deleteRentInDatabase(preparedStatement, applicantId);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }        

        return isInserted;
    }
    
    public boolean UpdateTenantRental(int tenantId, int room, int rent){
        jdbc javaJdbc=new jdbc();
        String query = "DELETE FROM applyRental WHERE applicantId = ?";
        boolean isInserted = false;

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            //javaJdbc.deleteRentInDatabase(preparedStatement, tenantId);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }        

        return isInserted;
    }
    public boolean UpdateRoomStatus(int roomId){
        jdbc javaJdbc=new jdbc();
        String query = "UPDATE room SET status = '1' WHERE roomId = ?";
        boolean isInserted = false;

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            javaJdbc.UpdateRoomInDatabase(preparedStatement, roomId);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }        

        return isInserted;
    }

}
