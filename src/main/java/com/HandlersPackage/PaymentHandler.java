package com.HandlersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.BussinessLogic.DB.jdbc;


public class PaymentHandler {
    

    public int calculateRent(int tenantId){
        jdbc javaJdbc=new jdbc();
        int roomRent = 0;
        int fineAmount = 0;
        String roomRentQuery = "Select amount FROM rent WHERE tenantId = ?";
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(roomRentQuery);) {
            preparedStatement.setInt(1, tenantId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                roomRent = rs.getInt("amount");
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        System.out.println("done user");

        String fineAmountQuery = "Select amount from fine WHERE tenantId = ?";
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(fineAmountQuery);) {
            preparedStatement.setInt(1, tenantId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                fineAmount = rs.getInt("amount");
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        System.out.println("done user");

        int breakfastAmount = 0;
        int lunchAmount = 0;
        int dinnerAmount = 0;

        String mealPriceQuery = "SELECT \r\n" + //
                        "    mb.price AS breakfast_price,\r\n" + //
                        "    ml.price AS lunch_price,\r\n" + //
                        "    md.price AS dinner_price\r\n" + //
                        "FROM \r\n" + //
                        "    selectMenu sm\r\n" + //
                        "JOIN \r\n" + //
                        "    menu m ON sm.menuId = m.menuId\r\n" + //
                        "JOIN \r\n" + //
                        "    meals mb ON m.breakfast = mb.mealId\r\n" + //
                        "JOIN \r\n" + //
                        "    meals ml ON m.lunch = ml.mealId\r\n" + //
                        "JOIN \r\n" + //
                        "    meals md ON m.dinner = md.mealId\r\n" + //
                        "WHERE \r\n" + //
                        "    sm.tenantId = ?;";
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(mealPriceQuery);) {
            preparedStatement.setInt(1, tenantId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                breakfastAmount = rs.getInt("breakfast_price");
                lunchAmount = rs.getInt("lunch_price");
                dinnerAmount = rs.getInt("dinner_price");
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        System.out.println("done user");
        System.err.println("Room Rent: "+ roomRent);
        System.err.println("Fine Amount: "+ fineAmount);
        System.err.println("Breakfast Amount: "+ breakfastAmount);
        System.err.println("Lunch Amount: "+ lunchAmount);
        System.err.println("Dinner Amount: "+ dinnerAmount);

        int totalRent = roomRent + fineAmount + breakfastAmount + lunchAmount + dinnerAmount;

        return totalRent;

    }

    public boolean processPayment(int tenantID, String method, int amount){
        boolean status = false;
        int total = amount;
        String query = "INSERT INTO payment (methode, total, status, tenantId) VALUES (?,?,?,?)";
        jdbc javaJdbc= jdbc.getInstance();
        boolean isInserted = false;

        try (Connection connection = javaJdbc.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                status=true;
            javaJdbc.insertPaymentInDatabase(preparedStatement, method, total, status, tenantID);
            isInserted=true;
        } catch (Exception e) {
            e.printStackTrace();
        }        

        return isInserted;

    }
}
