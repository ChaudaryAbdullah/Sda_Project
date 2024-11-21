package com.BussinessLogic.classes;
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
    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }
    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for totalRooms
    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    // Getter and Setter for availableRooms
    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    // Getter and Setter for facilities
    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }
}
