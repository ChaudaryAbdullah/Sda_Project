package com.BussinessLogic.classes;

import java.util.ArrayList;
import java.util.List;

public class Rental {
    private int id;
    private String name;
    private String address;
    private String facilities;
    private int totalRooms;
    private int availableRooms;
    List<parking> parkingList;
    // Default constructor

    public  Rental(){
        parkingList=new ArrayList<>();
    }

    // Parameterized constructor
    public  Rental(int id, String name, String address, String facilities, int totalRooms, int availableRooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.facilities = facilities;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
        parkingList=new ArrayList<>();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    // toString method
    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", facilities='" + facilities + '\'' +
                ", totalRooms=" + totalRooms +
                ", availableRooms=" + availableRooms +
                '}';
    }

    public void addparking(parking park){
        parkingList.add(park);

    }
}
