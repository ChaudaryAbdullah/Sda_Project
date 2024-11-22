package com.BussinessLogic.classes;

public class parking {
    private int slotId;
    private boolean occupancy;
    private int rental;

    // Default constructor
    public void Parking() {
    }
    
    public void Parking(int slotId, boolean occupancy, int rental) {
        this.slotId = slotId;
        this.occupancy = occupancy;
        this.rental = rental;
    }

    // Getters and Setters
    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isOccupancy() {
        return occupancy;
    }

    public void setOccupancy(boolean occupancy) {
        this.occupancy = occupancy;
    }

    public int getRental() {
        return rental;
    }

    public void setRental(int rental) {
        this.rental = rental;
    }

    
}
