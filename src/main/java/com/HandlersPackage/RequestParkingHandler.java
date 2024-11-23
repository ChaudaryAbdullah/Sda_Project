package com.HandlersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BussinessLogic.DB.LoadData;
import com.BussinessLogic.DB.jdbc;
import com.BussinessLogic.classes.Rental;
import com.BussinessLogic.classes.Room;
import com.BussinessLogic.classes.parking;
import com.Factories.ParkingFactory;
import com.Factories.RentalFactory;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class RequestParkingHandler {
     private List<Rental> rentals;
    private List<parking> parkings;
    ParkingFactory parkingFactory=new ParkingFactory();
    RentalFactory rentalFactory=new RentalFactory();
    public RequestParkingHandler(){
        rentals=new ArrayList<>();
        parkings=new ArrayList<>();
    }

    public void addParking(int ID){
         jdbc javaJdbc=new jdbc();
        String query = "select * from parkingslot p \n" + //
                        "inner join rental r on r.rentalId=p.rentalId\n" + //
                        "inner join rent re on re.rentalId=r.rentalId\n" + //
                        "where re.tenantId=? and p.is_occupied=0;";
                        
            try (Connection conn = javaJdbc.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);) {
                preparedStatement.setInt(1, ID);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
               Rental r=rentalFactory.cretaRental(rs.getInt("rentalId"),rs.getString("rentalName"),rs.getString("address"),rs.getString("facilities"),rs.getInt("totalRooms"),rs.getInt("availableRooms"));
               parking p=parkingFactory.createParking(rs.getInt("slotId"), rs.getBoolean("is_occupied"), rs.getInt("rentalId"));
                rentals.add(r);
                parkings.add(p);
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
    public TableView tableHandler(TableView table,int id){
        LoadData util=new LoadData();        
        return util.loadRequestParkingData(table,id);
    }


    public ComboBox HandleComboBox(ComboBox combo){    
        for (parking parking : parkings) {
            combo.getItems().add(String.valueOf(parking.getSlotId()));
        }
    return combo;
    
}
    public void ChooseParking(String data,int userid){
        int parking=Integer.parseInt(data);
        
        String query="INSERT INTO parkingrequest(slotId,tenantId) VALUES(?,?)";
        jdbc javaJdbc=new jdbc();
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
        javaJdbc.insertRequestParkingInDatabase(preparedStatement,parking,userid);   
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
}
