package com.HandlersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.BussinessLogic.DB.jdbc;
import com.BussinessLogic.classes.Notification;
import com.Factories.NotificationFactory;

public class NotificationHandler {
    Notification notification;

    public void sendNotificationToTenant(String desc,int id){
        notification=NotificationFactory.createNotification(desc, id);
        String query="INSERT INTO sendnotificationtenant (tenantID, NotificationID)\n" + //
                        "VALUES (?,?)";
        QueryRunner(query);
    }

    public void sendNotificationToOwner(String desc,int id){
        notification=NotificationFactory.createNotification(desc, id);
        String query="INSERT INTO sendnotificationtenant (tenantID, NotificationID)\n" + //
                        "VALUES (?,?)";
        QueryRunner(query);
    }

    private void QueryRunner(String query){
        jdbc javaJdbc=new jdbc();
        int notificationId=-1;
        String query1="INSERT INTO Notification (description, DateTime)\n" + //
                        "VALUES (?,?)";
        
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query1, PreparedStatement.RETURN_GENERATED_KEYS)){
        notificationId=javaJdbc.insertNotificationInDatabase(preparedStatement,notification.getDescription(),notification.getDateTime());   
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(notificationId!=-1)
        {
            try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
        javaJdbc.insertNotificationUserInDatabase(preparedStatement,notification.getId(),notificationId); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
}
