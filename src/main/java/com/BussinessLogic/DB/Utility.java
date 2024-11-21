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
    
	

	}
