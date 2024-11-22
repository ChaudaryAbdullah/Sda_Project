package com.BussinessLogic.classes;
import java.util.List;

public class Menu {
    private int id;
    private Meal breakfast;
    private Meal lunch;
    private Meal dinner;
    private String description;
    private int ownerId;

    public Menu() {
    }

    public Menu(int id,Meal brMeal,Meal lMeal,Meal dMeal,String desc,int ownerID){
        this.id=id;
        this.breakfast=brMeal;
        this.lunch=lMeal;
        this.dinner=dMeal;
        this.description=desc;
        this.ownerId=ownerID;
    }

    // Getters and Setters
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public Meal getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Meal breakfast) {
        this.breakfast = breakfast;
    }

    public Meal getLunch() {
        return lunch;
    }

    public void setLunch(Meal lunch) {
        this.lunch = lunch;
    }

    public Meal getDinner() {
        return dinner;
    }

    public void setDinner(Meal dinner) {
        this.dinner = dinner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    // ToString method for debugging and display
    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", breakfast=" + (breakfast != null ? breakfast.getName() : "None") +
                ", lunch=" + (lunch != null ? lunch.getName() : "None") +
                ", dinner=" + (dinner != null ? dinner.getName() : "None") +
                ", description='" + description + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }
}
