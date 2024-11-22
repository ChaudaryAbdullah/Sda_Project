package com.Factories;

import com.BussinessLogic.classes.Meal;

public class MealFactory {

    public Meal CreateMeal(int id, String name, String description, long price) {
        return new Meal(id, name, description, price);
    }
    
}
