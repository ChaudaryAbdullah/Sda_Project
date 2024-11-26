package com.Factories;

import com.BussinessLogic.classes.parking;

public class ParkingFactory {
    public static parking createParking(int id,boolean occupancy,int rental){
        parking p=new parking();
        p.Parking(id, occupancy, rental);
        return p;
        
    }
}
