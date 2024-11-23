package com.HandlersPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BussinessLogic.loadDataPackage.LoadData;
import com.BussinessLogic.DB.jdbc;
import com.BussinessLogic.classes.Meal;
import com.BussinessLogic.classes.Menu;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class AddMenuHandler {
    private List<Meal> meals;
    private List<Menu> menus;

    public AddMenuHandler(){
        meals=new ArrayList<>();
        menus=new ArrayList<>();
    }

    public void addMenu(){
        jdbc javaJdbc=new jdbc();
        String query = "SELECT * from menu" + //
                        "LEFT JOIN meals AS breakfast ON menu.breakfast = breakfast.mealId\n" + //
                        "LEFT JOIN meals AS lunch ON menu.lunch = lunch.mealId\n" + //
                        "LEFT JOIN meals AS dinner ON menu.dinner = dinner.mealId;";
                        
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Meal m1=new Meal(rs.getInt("mealId"),rs.getString("name"),rs.getString("description"),rs.getLong("price"));
                Meal m2=new Meal(rs.getInt("mealId"),rs.getString("name"),rs.getString("description"),rs.getLong("price"));
                Meal m3=new Meal(rs.getInt("mealId"),rs.getString("name"),rs.getString("description"),rs.getLong("price"));
                Menu u=new Menu(rs.getInt("menuId"),m1,m2,m3,rs.getString("description"),rs.getInt("ownerId"));
                menus.add(u);
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    public void addMeal(){
        jdbc javaJdbc=new jdbc();
        String query = "SELECT * from meals";
                        
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Meal m=new Meal(rs.getInt("mealId"),rs.getString("name"),rs.getString("description"),rs.getLong("price"));
                meals.add(m);
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ComboBox HandleComboBox(ComboBox combo){    
            for (Meal meal : meals) {
                combo.getItems().add(meal.getId()+" : "+meal.getName());
            }
        return combo;
        
    }

    public void addNewMenu(String breakfast,String lunch,String dinner,String desc,int userid){
        int breakfastId=Integer.parseInt(breakfast.split(" : ")[0]);
        int lunchId=Integer.parseInt(lunch.split(" : ")[0]);
        int dinnerId=Integer.parseInt(dinner.split(" : ")[0]);

        String query="INSERT INTO menu (breakfast, lunch, dinner, description, ownerId) VALUES (?,?,?,?,?)";
        jdbc javaJdbc=new jdbc();
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
        javaJdbc.insertMenuInDatabase(preparedStatement,breakfastId,lunchId,dinnerId,desc,userid);   
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("rawtypes")
    public TableView HandleTable(TableView table){
        LoadData util=new LoadData();
        return util.loadAddMenuData(table);
    }
}
