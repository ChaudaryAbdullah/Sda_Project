package com.Factories;

import com.BussinessLogic.classes.Rental;

public class RentalFactory {
    private static String generateUniqueID() {
        return "REN-" + System.currentTimeMillis();
    }

    public Rental cretaRental(int id, String name, String address, String facilities, int totalRooms, int availableRooms){
        return new Rental(id, name, address, facilities, totalRooms, availableRooms);
    }
    
}
