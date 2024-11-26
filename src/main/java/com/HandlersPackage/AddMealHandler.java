package com.HandlersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.BussinessLogic.DB.jdbc;
import com.BussinessLogic.loadDataPackage.LoadData;

import javafx.scene.control.TableView;

public class AddMealHandler {

    public boolean addNewMeal(String name, String desc, long price) {
        String query = "INSERT INTO meals (name, description, price) VALUES (?, ?, ?)";
        jdbc javaJdbc = jdbc.getInstance();
        System.out.println(name);
        System.out.println(desc);
        System.out.println(price);
        try (Connection conn = javaJdbc.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
             
            return javaJdbc.insertMealsnInDatabase(preparedStatement, name, desc, price);
        } catch (Exception e) {
            System.err.println("Error adding new meal: " + e.getMessage());
            e.printStackTrace();
            return false; // Return false to indicate failure
        }
    }

    @SuppressWarnings("rawtypes")
    public TableView tableHandler(TableView table) {
       LoadData util=new LoadData();        
        return util.loadMealData(table);
    }
}
