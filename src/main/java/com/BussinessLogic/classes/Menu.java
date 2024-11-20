package com.BussinessLogic.classes;
import java.util.List;

public class Menu {
    private String menuID;
    private String description;

    private List<MenuItem> items;

    public Menu(String menuID, String description) {
        this.menuID = menuID;
        this.description = description;
    }

    public void addMenuItem(MenuItem item) {
    }

    public void removeMenuItem(String itemID) {
    }

    public List<MenuItem> displayMenu() {
        return items;
    }
}
