package com.HandlersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BussinessLogic.loadDataPackage.LoadData;
import com.BussinessLogic.DB.jdbc;
import com.BussinessLogic.loadDataPackage.loadNotificationData;
import com.BussinessLogic.classes.Rental;
import com.BussinessLogic.classes.Room;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class chooseRentalHandler {
    private List<Rental> rentals;
    private List<Room> rooms;
    public chooseRentalHandler(){
        rentals=new ArrayList<>();
        rooms=new ArrayList<>();
    }

    public void addRentalandrooms(int ID){
         jdbc javaJdbc=new jdbc();
        String query = "select * from rental r \n" + //
                        "join rent on r.rentalId=rent.rentalId \n" + //
                        "join room on r.rentalId=room.rentalId \n" + //
                        "join owns o on o.rentalId=r.rentalId\n" + //
                        "where o.ownerid!=?";
                        
            try (Connection conn = javaJdbc.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);) {
                preparedStatement.setInt(1, ID);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                System.out.println("rental  "+rs.getInt(1));
                System.out.println("room  "+rs.getInt(9));
               Rental r=new Rental(rs.getInt("rentalId"),rs.getString("rentalName"),rs.getString("address"),rs.getString("facilities"),rs.getInt("totalRooms"),rs.getInt("availableRooms"));
               Room room=new Room(rs.getInt("roomId"), rs.getString("rtype"), rs.getString("status"), rs.getString("descript"), rs.getInt("price"), rs.getInt("rentalId"), rs.getString("picture"));
                rentals.add(r);
                rooms.add(room);
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("rawtypes")
    public TableView tableHandler(TableView table,int id){
        LoadData util=new LoadData();        
        return util.loadChoseRentalData(table,id);
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ComboBox HandleComboBox(ComboBox combo){    
        for (int i = 0; i < rooms.size(); i++) {
            combo.getItems().add(rooms.get(i).getRoomId()+" : "+rooms.get(i).getRtype()+" : "+rooms.get(i).getPrice()+" : "+rooms.get(i).getRentalId());
        }
    return combo;
    
}
    public void ChooseRental(String data,int userid){
        int rentalId=Integer.parseInt(data.split(" : ")[3]);
        int roomId=Integer.parseInt(data.split(" : ")[0]);
        
        String query="INSERT INTO applyrental(rentalId,roomId,applicantId) VALUES(?,?,?)";
        jdbc javaJdbc=new jdbc();
        try (Connection conn = javaJdbc.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query)){
            javaJdbc.insertApplyRentalInDatabase(preparedStatement,roomId,rentalId,userid);   
            Rental r=rentals.stream()
            .filter(obj -> obj.getId() == rentalId) 
            .findFirst()
            .orElse(null);
            int ownerid= new loadNotificationData().loadOwner(rentalId);
            NotificationHandler notification=new NotificationHandler();
            notification.sendNotificationToTenant("You got request for Room Number  "+roomId+" of "+ r.getName(),ownerid);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
