package com.HandlersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BussinessLogic.DB.jdbc;
import com.BussinessLogic.loadDataPackage.loadNotificationData;
import com.Factories.RentalFactory;
import com.BussinessLogic.classes.Rental;

import javafx.scene.control.ComboBox;

public class GiveFeedbackHandler {
    List<Rental> rentals;

    public GiveFeedbackHandler(){
        rentals=new ArrayList<>();
    }

     public void addRental(int ID){
        jdbc javaJdbc=jdbc.getInstance();
        String query="select * from rental r \n" + //
                        "join rent re on re.rentalId=r.rentalId\n" + //
                        "where re.tenantId=?";
         try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Rental r=RentalFactory.createRental(rs.getInt("rentalId"), rs.getString("rentalName"), rs.getString("address"), rs.getString("facilities"), rs.getInt("totalRooms"), rs.getInt("availableRooms"));
                rentals.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ComboBox HandleComboBox(ComboBox combo){    
            for (Rental rent : rentals) {
                combo.getItems().add(rent.getId()+" : "+rent.getName() + " : " + rent.getAddress());
            }
        return combo;
    }

    public void newFeedback(String data,int userId,String desc,int rating){
        int rentalId=Integer.parseInt(data.split(" : ")[0]);
        
        String query="INSERT INTO feedback (rating, description, rentalId, tenantId) VALUES (?,?,?,?)";
        jdbc javaJdbc=jdbc.getInstance();
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
            javaJdbc.insertGiveFeedbackInDatabase(preparedStatement, rating,desc,rentalId,userId);   
            Rental r=rentals.stream()
            .filter(obj -> obj.getId() == rentalId) 
            .findFirst()
            .orElse(null);
            int ownerid= new loadNotificationData().loadOwner(rentalId);
            NotificationHandler notification=new NotificationHandler();
            notification.sendNotificationToTenant("You got a feedback for  "+r.getName(),ownerid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
