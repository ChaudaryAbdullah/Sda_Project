package com.BussinessLogic.classes;
import java.util.List;

public class Feedback {
    private String feedbackID;
    private int rating;
    private String description;

    private HostelRental rental;

    public Feedback(String feedbackID, int rating, String description) {
        this.feedbackID = feedbackID;
        this.rating = rating;
        this.description = description;
    }

    
    public void recordFeedback(String tenantID, String rentalID, String feedbackText, int rating) {
       
    }

    public List<Feedback> showFeedback(String rentalID) {
       
        return null;
    }

    public double calculateRating(String rentalID) {
     
        return 0.0;
    }
}
