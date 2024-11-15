package com.example;
import java.util.List;

public class HostelRental {
    private String propertyID;
    private String address;
    private int totalRooms;
    private int availableRooms;
    private String facilities;

    private List<Tenant> tenants;
    private Owner owner;

    public HostelRental(String propertyID, String address, int totalRooms, int availableRooms, String facilities) {
        this.propertyID = propertyID;
        this.address = address;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
        this.facilities = facilities;
    }

    public void addTenant(Tenant tenant) {
    }

    public void removeTenant(String tenantID) {
    }

    public List<Tenant> displayTenants() {
        return null;
    }
}
