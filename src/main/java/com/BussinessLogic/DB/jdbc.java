package com.BussinessLogic.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.BussinessLogic.classes.*;

public class jdbc {
    public Connection getConnection() throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/sda_project";
		String username = "root";
		String password = "12345678";
		System.out.println("Connecting database");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    void insertUserInDatabase(PreparedStatement preparedStatement, String userName, String firstName, String lastName, String dob, String pass, String address) throws SQLException
    {
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, lastName);
        preparedStatement.setString(4, address);
        preparedStatement.setString(5, dob);
        preparedStatement.setString(6, pass);

        // Execute update
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("User added successfully!");
        } else {
            Error err=new Error("Failed to add user.");
            throw err;
            
        }
    }

    User getUserFromDatabase(PreparedStatement preparedStatement) throws SQLException{

        // Execute query
        ResultSet resultSet = preparedStatement.executeQuery();
 
        // Process results
        if (resultSet.next()) {
            int id = resultSet.getInt("ownerid");
            String firstname = resultSet.getString("firstname");
            String lastname=resultSet.getString("lastname");
            String dob=resultSet.getDate("dob").toString();
            String passwordString=resultSet.getString("password");
            String userName = resultSet.getString("username");
            String address=resultSet.getString("address");
            
            System.out.println("User Details:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + firstname);
            System.out.println("UserName: " + userName);
            User user=new Owner(id,userName,firstname,lastname,address,dob,passwordString);
            return user;
        } else {
           return null;
        }
    }

    void insertRentalInDatabase(PreparedStatement preparedStatement, String name, String address, String  facilities, String totalRoomsStr, String availableRoomsStr) throws SQLException
    {
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, address);
        preparedStatement.setString(3, facilities);
        preparedStatement.setString(4, totalRoomsStr);
        preparedStatement.setString(5, availableRoomsStr);

        // Execute update
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Rental added successfully!");
        } else {
            Error err=new Error("Failed to add Rental.");
            throw err;
            
        }
    }

    void insertRoomInDatabase(PreparedStatement preparedStatement, String roomType, String roomStatus, String  descrip, String priceString, String rentalIdString, String imagePath) throws SQLException
    {
        preparedStatement.setString(1, roomType);
        preparedStatement.setString(2, roomStatus);
        preparedStatement.setString(3, descrip);
        preparedStatement.setString(4, priceString);
        preparedStatement.setString(5, rentalIdString);
        preparedStatement.setString(6, imagePath);

        // Execute update
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Room added successfully!");
        } else {
            Error err=new Error("Failed to add Room.");
            throw err;
            
        }
    }
    public HostelRental getRentalIdForTenant(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
 
        // Process results
        if (resultSet.next()) {
            int id = resultSet.getInt("rentalId");
            String name = resultSet.getString("rentalName");
            String address = resultSet.getString("address");
            String facilities = resultSet.getString("facilities");
            int totalRooms = resultSet.getInt("totalRooms");
            int availableRooms = resultSet.getInt("availableRooms");

            String IdString = String.valueOf(id);
            System.out.println("User Details:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("UserName: " + address);
            HostelRental hos =new HostelRental(IdString,address,totalRooms,availableRooms,facilities);
            return hos;
        } else {
           return null;
        }
    }

    public void insertEvictionInDatabase(PreparedStatement preparedStatement, String todayDate, String evictionDate, String rentalIdString, String tenantIdString, String ownerIDString, String reason) throws SQLException{
        preparedStatement.setString(1, todayDate);
        preparedStatement.setString(2, evictionDate);
        preparedStatement.setString(3, tenantIdString);
        preparedStatement.setString(4, ownerIDString);
        preparedStatement.setString(5, reason);

        // Execute update
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Eviction added successfully!");
        } else {
            Error err=new Error("Failed to add Eviction.");
            throw err;
            
        }
    }

    public void insertMaintainceInDatabase(PreparedStatement preparedStatement, String description, String status, String date, String rentalId) throws SQLException{
        preparedStatement.setString(1, description);
        preparedStatement.setString(2, status);
        preparedStatement.setString(3, date);
        preparedStatement.setString(4, rentalId);

        // Execute update
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Maintaince added successfully!");
        } else {
            Error err=new Error("Failed to add Maintaince.");
            throw err;
            
        }
       
    }
    public void UpdateMaintainceInDatabase(PreparedStatement preparedStatement, Boolean status, String todayDate, String maintainceString) throws SQLException{
        preparedStatement.setBoolean(1, status);
        preparedStatement.setString(2, todayDate);
        preparedStatement.setString(3, maintainceString);

        // Execute update
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Maintaince added successfully!");
        } else {
            Error err=new Error("Failed to add Maintaince.");
            throw err;
            
        }
    }

    public void insertFineInDatabase(PreparedStatement preparedStatement, String todayDate, String reasonString, String fine, String ownerIdString, String tenantID) throws SQLException{
        preparedStatement.setString(1, todayDate);
        preparedStatement.setString(2, reasonString);
        preparedStatement.setString(3, fine);
        preparedStatement.setString(4, ownerIdString);
        preparedStatement.setString(5, tenantID);
        // Execute update
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Fine added successfully!");
        } else {
            Error err=new Error("Failed to add Fine.");
            throw err;
            
        }
    }
    public void insertRentInDatabase(PreparedStatement preparedStatement, int tenantId, int rentalId) throws SQLException{
        preparedStatement.setInt(1, tenantId);
        preparedStatement.setInt(2, rentalId);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Rent added successfully!");
        } else {
            Error err=new Error("Failed to add Rent.");
            throw err;
            
        }
    }

    public void deleteRentInDatabase(PreparedStatement preparedStatement, int applicantId) throws SQLException{
        preparedStatement.setInt(1, applicantId);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Rent deleted successfully!");
        } else {
            Error err=new Error("Failed to delete Rent.");
            throw err;
            
        }
    }

    public void insertSlotInDatabase(PreparedStatement preparedStatement,int rentalId) throws SQLException{
        preparedStatement.setInt(1, rentalId);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Parking added successfully!");
        } else {
            Error err=new Error("Couldn't add parking.");
            throw err;
        }
    }

    public void insertAllocationInDatabase(PreparedStatement preparedStatement,int rentalId,int parkingId) throws SQLException{
        preparedStatement.setInt(2, rentalId);
        preparedStatement.setInt(1, parkingId);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Allocation made successfully!");
        } else {
            Error err=new Error("Couldn't allocate parking.");
            throw err;
        }
    }

    public void removeRequestFromDatabase(PreparedStatement preparedStatement,int slot, int user) throws SQLException{
        preparedStatement.setInt(2, user);
        preparedStatement.setInt(1, slot);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("deletion done successfully!");
        } else {
            Error err=new Error("Couldn't delete request.");
            throw err;
        }
    }
    public void UpdateRentInDatabase(PreparedStatement preparedStatement, int room, int rent, int tenantId) throws SQLException{
        preparedStatement.setInt(1, room);
        preparedStatement.setInt(2, rent);
        preparedStatement.setInt(3, tenantId);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Rent deleted successfully!");
        } else {
            Error err=new Error("Failed to delete Rent.");
            throw err;
            
        }
    }
    public void UpdateRoomInDatabase(PreparedStatement preparedStatement, int roomId) throws SQLException{
        preparedStatement.setInt(1, roomId);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Rent deleted successfully!");
        } else {
            Error err=new Error("Failed to delete Rent.");
            throw err;
            
        }
    }

   

    
}