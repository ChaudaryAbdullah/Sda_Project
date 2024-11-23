package com.BussinessLogic.loadDataPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BussinessLogic.DB.jdbc;

import javafx.scene.control.TableView;

public class loadNotificationData {
 
    public int loadOwner(int ID) throws SQLException {
         jdbc javaJdbc=new jdbc();
        String query = "select * from owns where owns.rentalid=?";   
            try (Connection conn = javaJdbc.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);) {
                preparedStatement.setInt(1, ID);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next()){
                    return Integer.parseInt(rs.getString("ownerId"));
                }
    }
                return -1;
    }
}
