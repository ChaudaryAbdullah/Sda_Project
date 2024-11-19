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

	public boolean addUser(String userName, String firstName, String lastName, String dob, String pass, String address){
		
		String url = "jdbc:mysql://localhost:3306/sda_project";
		String username = "root";
		String password = "12345678";
		System.out.println("Connecting database");
		String query = "INSERT INTO owner (userName, firstName, lastName, address, dob, password) VALUES (?, ?, ?, ?, ?, ?)";
        boolean isInserted = false;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set query parameters
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
                isInserted = true;
            } else {
                System.out.println("Failed to add user.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

		query = "INSERT INTO applicant (userName, firstName, lastName, address, dob, password) VALUES (?, ?, ?, ?, ?, ?)";
        isInserted = false;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set query parameters
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
                isInserted = true;
            } else {
                System.out.println("Failed to add user.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

		query = "INSERT INTO tenant (userName, firstName, lastName, address, dob, password) VALUES (?, ?, ?, ?, ?, ?)";
        isInserted = false;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set query parameters
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

                // Create Owner object
                Owner owner = new Owner();
                owner.setID(query);//add query
                owner.setUsername(userName);
                owner.setFirstname(firstName);
                owner.setLastname(lastName);
                owner.setDob(dob);
                owner.setPassword(password);
                owner.setAddress(address);

                isInserted = true;
            } else {
                System.out.println("Failed to add user.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isInserted;
    }
	

	

}
