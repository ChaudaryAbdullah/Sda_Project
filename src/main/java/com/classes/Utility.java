package com.classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Utility {
    
    public boolean getUser(String user,String pass){

		String url = "jdbc:mysql://localhost:3306/sda_project";
		String username = "root";
		String password = "12345678";
		System.out.println("Connecting database");
		boolean state=false;
		String query = "SELECT * FROM owner WHERE username = ? && password = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	   // Set query parameter
	   preparedStatement.setString(1, user);
	   preparedStatement.setString(2, pass);

	   // Execute query
	   ResultSet resultSet = preparedStatement.executeQuery();

	   // Process results
	   if (resultSet.next()) {
		   int id = resultSet.getInt("ownerid");
		   String firstname = resultSet.getString("firstname");
		   String lastname=resultSet.getString("lastname");
		   Date dob=resultSet.getDate("dob");
		   String passwordString=resultSet.getString("password");
		   String email = resultSet.getString("username");
		   String address=resultSet.getString("address");
		   
		   System.out.println("User Details:");
		   System.out.println("ID: " + id);
		   System.out.println("Name: " + firstname);
		   System.out.println("UserName: " + email);
		   state=true;
	   } else {
		   System.out.println("No user found with Username: " + user);
	   }
					
					connection.close();
		}catch(Exception e) {
			e.printStackTrace();

		}
		return state;
	}

}