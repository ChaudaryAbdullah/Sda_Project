package com.classes;

import java.util.List;

public class Owner {
    private String ownerID;
    private String name;
    private String contactInfo;

    private List<HostelRental> properties;

    public Owner(String ownerID, String name, String contactInfo) {
        this.ownerID = ownerID;
        this.name = name;
        this.contactInfo = contactInfo;
    }


    public List<Applicant> viewApplicants(String rentalID) {
       
        return null;
    }

    public void approveApplicant(String rentalID, String tenantID) {
     
    }

    public void sendApprovalNotification(String tenantID, String details) {
      
    }
}
