package com.classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    
    public User getUser(String user,String pass){

		boolean state=false;
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
            }
			
            connection.close(); 
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
        
         // Create Owner object
                // Owner owner = new Owner();
                // owner.setID(query);//add query
                // owner.setUsername(userName);
                // owner.setFirstname(firstName);
                // owner.setLastname(lastName);
                // owner.setDob(dob);
                // owner.setPassword(pass);
                // owner.setAddress(address);
        return isInserted;
    }
	

	

}
