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

public class SelectMenuHandler{
    List<Menu> menus;

    public SelectMenuHandler(){
        menus=new ArrayList<>();
    }


    public void addMenu(){
        jdbc javaJdbc=new jdbc();
        String query = "SELECT * from menu " + //
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

    public ComboBox HandleComboBox(ComboBox combo){    
            for (Menu menu : menus) {
                combo.getItems().add(String.valueOf(menu.getID()));
            }
        return combo;
    }

    public void ChooseMenu(String data,int userid){
        int menuId=Integer.parseInt(data);

        String query="INSERT INTO selectmenu (tenantId,menuId) VALUES (?,?)";
        jdbc javaJdbc=new jdbc();
        try (Connection conn = javaJdbc.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)){
        javaJdbc.insertselectMenuInDatabase(preparedStatement,userid,menuId);   
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

     public TableView tableHandler(TableView table){
        LoadData util=new LoadData();        
        return util.loadAddMenuData(table);
    }
}
