package com.BussinessLogic.classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Notification {
    private int id;
    private String dateTime;
    private String description;

    public Notification(int id, String description) {
        this.id = id;
        SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dateTime = sqlDateFormat.format(new Date());
        this.description = description;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for dateTime
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    @Override
    public String toString() {
        return "Notification{" +
                "dateTime='" + dateTime + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
