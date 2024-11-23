package com.HandlersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BussinessLogic.DB.jdbc;
import com.BussinessLogic.classes.Rental;

import javafx.scene.control.ComboBox;

public class GiveFeedbackHandler {
    List<Rental> rentals;

    public GiveFeedbackHandler(){
        rentals=new ArrayList<>();
    }

     public void addRental(int ID){
        jdbc javaJdbc=new jdbc();
        String query="select * from rental r \n" + //
                        "join rent re on re.rentalId=r.rentalId\n" + //
                        "where re.tenantId=?";
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

    public ComboBox HandleComboBox(ComboBox combo){    
            for (Rental rent : rentals) {
                combo.getItems().add(rent.getId()+" : "+rent.getName() + " : " + rent.getAddress());
            }
        return combo;
    }

    public void newFeedback(String data,int userId,String desc,int rating){
        int rentalId=Integer.parseInt(data.split(" : ")[0]);
        
        String query="INSERT INTO feedback (rating, description, rentalId, tenantId) VALUES (?,?,?,?)";
        jdbc javaJdbc=new jdbc();
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
            javaJdbc.insertGiveFeedbackInDatabase(preparedStatement, rating,desc,rentalId,userId);   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
