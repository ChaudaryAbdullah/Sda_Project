package com.BussinessLogic.classes;

public class Meal {
    private int id;                 // Unique identifier for the meal
    private String name;            // Name of the meal
    private String description;     // Description of the meal
    private long price;             // Price of the meal in cents or as an integer

    // Constructor
    public Meal(int id, String name, String description, long price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Default Constructor (Optional)
    public Meal() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    // ToString method for easy debugging and display
    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
