package com.HandlersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BussinessLogic.DB.LoadData;
import com.BussinessLogic.DB.jdbc;
import com.BussinessLogic.classes.Rental;
import com.BussinessLogic.classes.User;
import com.BussinessLogic.classes.parking;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class AllocateParkingHandler {
    private List<Rental> rentals;
    private List<parking> park;

    public AllocateParkingHandler(){
        rentals=new ArrayList<>();
        park=new ArrayList<>();
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
            
            // TODO: handle exception
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

    public ComboBox HandleComboBox(ComboBox combo, int ID){    
            // Directly populate the ComboBox
            for (Rental rent : rentals) {
                combo.getItems().add(rent.getName() + " : " + rent.getAddress());
            }
        return combo;
        
    }

    public TableView HandleTable(TableView table,int ID){
        LoadData util=new LoadData();        
        return util.loadAllocateParkingData(table,ID);
    }
    
    public void newParking(String data,int amountOfParking){
            
        String name=data.split(" : ")[0];
        String address=data.split(" : ")[1];
        int id=0;

        for (Rental rent : rentals) {
            if(rent.getAddress()==address&&rent.getName()==name)
            {
                id=rent.getId();
                break;
            }
        }
        System.err.println(id);
        String query="INSERT INTO parkingslot (is_occupied, rentalId) VALUES (0,?)";
        jdbc javaJdbc=new jdbc();
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement =conn.prepareStatement(query)){

            for (int i = 0; i < amountOfParking; i++) {
                javaJdbc.insertSlotInDatabase(preparedStatement, id);   
            }

            System.out.println(name);
            System.out.println(address);
            System.out.println(amountOfParking);
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    
}
