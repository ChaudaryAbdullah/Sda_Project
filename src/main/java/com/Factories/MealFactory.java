package com.Factories;

import com.BussinessLogic.classes.Meal;

public class MealFactory {

    private static String generateUniqueID() {
        return "Meal-" + System.currentTimeMillis();
    }

    public Meal CreateMeal(int id, String name, String description, long price) {
        return new Meal(id, name, description, price);
    }
    
}
