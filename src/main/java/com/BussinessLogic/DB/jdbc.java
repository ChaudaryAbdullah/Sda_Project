package com.BussinessLogic.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.BussinessLogic.classes.*;

public class jdbc {
    Connection getConnection() throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/sda_project";
		String username = "root";
		String password = "12345678";
		System.out.println("Connecting database");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    void insertUserInDatabase(PreparedStatement preparedStatement, String userName, String firstName, String lastName, String dob, String pass, String address) throws SQLException
    {
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, lastName);
        preparedStatement.setString(4, address);
        preparedStatement.setString(5, dob);
        preparedStatement.setString(6, pass);

        // Execute update
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("User added successfully!");
        } else {
            Error err=new Error("Failed to add user.");
            throw err;
            
        }
    }

    User getUserFromDatabase(PreparedStatement preparedStatement) throws SQLException{

        // Execute query
        ResultSet resultSet = preparedStatement.executeQuery();
 
        // Process results
        if (resultSet.next()) {
            int id = resultSet.getInt("ownerid");
            String firstname = resultSet.getString("firstname");
            String lastname=resultSet.getString("lastname");
            String dob=resultSet.getDate("dob").toString();
            String passwordString=resultSet.getString("password");
            String userName = resultSet.getString("username");
            String address=resultSet.getString("address");
            
            System.out.println("User Details:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + firstname);
            System.out.println("UserName: " + userName);
            User user=new Owner(id,firstname,lastname,userName,address,dob,passwordString);
            return user;
        } else {
           return null;
        }
    }
}
