package com.BussinessLogic.DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.BussinessLogic.classes.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
                Error err=new Error("No user found with Username: " + user);
                connection.close(); 
                throw err;
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
	

	public TableView loadHomeData(TableView HomeTable) {
        jdbc javaJdbc=new jdbc();
        String query = "SELECT r.rentalName, r.address, r.availableRooms, r.totalRooms, r.facilities, " +
                       "CONCAT(o.firstName, ' ', o.lastName) AS ownerName " +
                       "FROM rental r " +
                       "JOIN owns own ON r.rentalId = own.rentalId " +
                       "JOIN owner o ON own.ownerId = o.ownerId";
    
        try (Connection conn = javaJdbc.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
    
            // Add columns dynamically
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                final int colIndex = i - 1;
                TableColumn<ObservableList<Object>, String> column = new TableColumn<>(rs.getMetaData().getColumnName(i));
                column.setCellValueFactory(param -> {
                    Object value = param.getValue().get(colIndex);
                    return new SimpleStringProperty(value != null ? value.toString() : "null");
                });
                HomeTable.getColumns().add(column);
            }
    
            // Add rows dynamically
            ObservableList<ObservableList<Object>> data = FXCollections.observableArrayList();
            while (rs.next()) {
                ObservableList<Object> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
            HomeTable.setItems(data);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
                return HomeTable;
    }
    
}
