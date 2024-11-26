package com.Factories;

import com.BussinessLogic.classes.Notification;

public class NotificationFactory {
    public static Notification createNotification(String desc,int userId){
        return new Notification(userId, desc);
    }
    
}
