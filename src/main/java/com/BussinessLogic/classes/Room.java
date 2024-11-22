package com.BussinessLogic.classes;

public class Room {
   public int roomId;
   public String rtype;
   public String status; 
   private String description;
   private int price;
   private int rentalId;
   private String picture;

   public Room() {}

   // Parameterized Constructor
   public Room(int roomId, String rtype, String status, String description, int price, int rentalId, String picture) {
       this.roomId = roomId;
       this.rtype = rtype;
       this.status = status;
       this.description = description;
       this.price = price;
       this.rentalId = rentalId;
       this.picture = picture;
   }

   // Getters and Setters
   public int getRoomId() {
       return roomId;
   }

   public void setRoomId(int roomId) {
       this.roomId = roomId;
   }

   public String getRtype() {
       return rtype;
   }

   public void setRtype(String rtype) {
       this.rtype = rtype;
   }

   public String getStatus() {
       return status;
   }

   public void setStatus(String status) {
       this.status = status;
   }

   public String getDescription() {
       return description;
   }

   public void setDescription(String description) {
       this.description = description;
   }

   public int getPrice() {
       return price;
   }

   public void setPrice(int price) {
       this.price = price;
   }

   public int getRentalId() {
       return rentalId;
   }

   public void setRentalId(int rentalId) {
       this.rentalId = rentalId;
   }

   public String getPicture() {
       return picture;
   }

   public void setPicture(String picture) {
       this.picture = picture;
   }

   // Override toString for better readability
   @Override
   public String toString() {
       return "Room{" +
               "roomId=" + roomId +
               ", rtype='" + rtype + '\'' +
               ", status='" + status + '\'' +
               ", description='" + description + '\'' +
               ", price=" + price +
               ", rentalId=" + rentalId +
               ", picture='" + picture + '\'' +
               '}';
   }
}
