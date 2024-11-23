package com.Factories;

import com.BussinessLogic.classes.Room;

public class RoomFactory {
    @SuppressWarnings("unused")
    private static String generateUniqueID() {
        return "ROOM-" + System.currentTimeMillis();
    }

    public Room createRoom(int roomId, String rtype, String status, String description, int price, int rentalId, String picture){
        return new Room(roomId, rtype, status, description, price, rentalId, picture);
    }
}
