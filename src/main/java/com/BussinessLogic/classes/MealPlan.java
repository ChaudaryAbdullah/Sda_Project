package com.BussinessLogic.classes;
import java.util.List;

public class MealPlan {
    private String name;
    private String description;
    private double pricing;

    private List<Menu> menus; // Aggregation: A meal plan contains multiple menus

    public MealPlan(String name, String description, double pricing) {
        this.name = name;
        this.description = description;
        this.pricing = pricing;
    }

    // Getters and setters
    public void subscribeTenant(Tenant tenant) {
        // Logic to subscribe a tenant
    }

    public void unsubscribeTenant(Tenant tenant) {
        // Logic to unsubscribe a tenant
    }

    public void generateInvoice(Tenant tenant) {
        // Logic to generate an invoice
    }
}
