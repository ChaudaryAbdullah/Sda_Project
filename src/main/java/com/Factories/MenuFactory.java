package com.Factories;

import com.BussinessLogic.classes.Meal;
import com.BussinessLogic.classes.Menu;

public class MenuFactory {
    public static Menu createMenu(int id,Meal brMeal,Meal lMeal,Meal dMeal,String desc,int ownerID){
        return new Menu(id, brMeal, lMeal, dMeal, desc, ownerID);
    }
    
}
