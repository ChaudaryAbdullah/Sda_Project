package com.Factories;

import com.BussinessLogic.classes.Rental;

public class RentalFactory {
    @SuppressWarnings("unused")
    private static String generateUniqueID() {
        return "REN-" + System.currentTimeMillis();
    }

    public static Rental createRental(int id, String name, String address, String facilities, int totalRooms, int availableRooms){
        return new Rental(id, name, address, facilities, totalRooms, availableRooms);
    }
    
}
