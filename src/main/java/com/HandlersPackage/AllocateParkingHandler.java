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

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class AllocateParkingHandler {
    private List<Rental> rentals;
    private List<parking> park;
    private List<parking> Requestpark;
    private List<User> users;

    public AllocateParkingHandler(){
        rentals=new ArrayList<>();
        park=new ArrayList<>();
        users=new ArrayList<>();
        Requestpark=new ArrayList<>();
    }

    public void addUser(int ID){
        jdbc javaJdbc=new jdbc();
        String query = "select * from parkingrequest pr \n" + //
                        "join tenant t on pr.tenantId=t.tenantId\n" + //
                        "join parkingslot p on p.slotId=pr.slotId\n" + //
                        "join rental r on r.rentalId=p.rentalId\n" + //
                        "join owns o on o.rentalId=r.rentalId\n" + //
                        "where o.ownerId=?";
                        
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                User u=new Tenant(rs.getInt("tenantId"),rs.getString("userName"), rs.getString("FirstName"), rs.getString("lastName"),rs.getString("address"),rs.getString("dob"),rs.getString("password"));
                users.add(u);
                parking p=new parking();
                p.Parking(rs.getInt("slotId"), rs.getBoolean("is_occupied"),   rs.getInt("rentalId"));
                Requestpark.add(p);
                System.err.println(u.getID());
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        System.out.println("done user");
    }

    public void addRental(int ID){
        jdbc javaJdbc=new jdbc();
        String query="select * from rental r \n" + //
                        "join owns o on o.rentalId=r.rentalId\n" + //
                        "where o.ownerId=?";
         try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Rental r=new Rental(rs.getInt("rentalId"), rs.getString("rentalName"), rs.getString("address"), rs.getString("facilities"), rs.getInt("totalRooms"), rs.getInt("availableRooms"));
                rentals.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void addParking(int ID){
        jdbc javaJdbc=new jdbc();
        String query="select * from parkingslot p \n" + //
                        "inner join rental r on r.rentalId=p.rentalId\n" + //
                        "inner join owns o on o.rentalId=r.rentalId\n" + //
                        "where o.ownerId=?";
         try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                parking p=new parking();
                p.Parking(rs.getInt("slotId"), rs.getBoolean("is_occupied"),   rs.getInt("rentalId"));
                park.add(p);

                for (Rental rent : rentals) {
                    if(rent.getId()==p.getRental()){
                        rent.addparking(p);
                    }
            }
            }

           
            
        } catch (Exception e) {
            
            // TODO: handle exception
        }
    }

    public ComboBox HandleRentalComboBox(ComboBox combo, int ID){    
            // Directly populate the ComboBox
            for (Rental rent : rentals) {
                combo.getItems().add(rent.getId()+" : "+rent.getName() + " : " + rent.getAddress());
            }
        return combo;
        
    }

    public ComboBox HandleParkingComboBox(ComboBox combo, int ID){    
        // Directly populate the ComboBox
        if (users==null||Requestpark==null) {
            return combo;
        }
        for (int i = 0; i < users.size(); i++) {
            combo.getItems().add(Requestpark.get(i).getSlotId()+" : "+users.get(i).getUsername()+" : "+users.get(i).getFullname());
        }
    return combo;
    
}

    public TableView HandleTable(TableView table,int ID){
        LoadData util=new LoadData();        
        return util.loadAllocateParkingData(table,ID);
    }
    
    public void newParking(String data,int amountOfParking){
            
        int id=Integer.parseInt(data.split(" : ")[0]);
        
        String query="INSERT INTO parkingslot (is_occupied, rentalId) VALUES (0,?)";
        jdbc javaJdbc=new jdbc();
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){

            for (int i = 0; i < amountOfParking; i++) {
                javaJdbc.insertSlotInDatabase(preparedStatement, id);   
            }

           
            System.out.println(amountOfParking);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void acceptParking(String data){
        int slotId=Integer.parseInt(data.split(" : ")[0]);
        String userName=data.split(" : ")[1];
        int userid=0;
        
        for (User user : users) {
            if (user.getUsername().matches(userName)) {
                userid=user.getID();
                break;
            }
        }
        
        String query="INSERT INTO parkingAllocation (slotId, tenantId) VALUES (?,?)";
        jdbc javaJdbc=new jdbc();
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
        javaJdbc.insertAllocationInDatabase(preparedStatement,userid,slotId);   
        } catch (Exception e) {
            e.printStackTrace();
        }

        query="DELETE FROM parkingRequest\n" + //
                        "WHERE slotId = ? AND tenantId = ?";
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
            javaJdbc.removeRequestFromDatabase(preparedStatement,slotId,userid);   
        } catch (Exception e) {
            e.printStackTrace();
        }                        
    }
    
    public void rejectParking(String data){
        int slotId=Integer.parseInt(data.split(" : ")[0]);
        String userName=data.split(" : ")[1];
        int userid=0;
        
        for (User user : users) {
            if (user.getUsername().matches(userName)) {
                userid=user.getID();
                break;
            }
        }
        jdbc javaJdbc=new jdbc();
        String query="DELETE FROM parkingRequest\n" + //
                        "WHERE slotId = ? AND tenantId = ?";
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
            javaJdbc.removeRequestFromDatabase(preparedStatement,slotId,userid);   
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
    
}
