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
                        "where o.ownerId=1";
         try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                parking p=new parking();
                p.Parking(rs.getInt("slotId"), rs.getBoolean("is_occupied"),   rs.getInt("rentalId"));
                park.add(p);
            }

            for (Rental rent : rentals) {
                for (parking parking : park) {
                    if(rent.getId()==parking.getRental()){
                        rent.addparking(parking);
                    }
                }  
            }
            
        } catch (Exception e) {
            
            // TODO: handle exception
        }
    }

    public void HandleComboBox(ComboBox combo, User user){
        LoadData util=new LoadData();
        combo=util.loadRentalDataComboBox(combo, user.getID());
    }
}
