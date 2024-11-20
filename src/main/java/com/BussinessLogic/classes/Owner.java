package com.BussinessLogic.classes;

import java.util.List;

public class Owner extends User{
  
    public Owner(int ID, String username, String firstname, String lastname, String address, String dob, String password) {
        super(ID, username, firstname, lastname, address, dob, password);
    }
    
    public Owner(){

    }

    public List<Applicant> viewApplicants(String rentalID) {
       
        return null;
    }

    public void approveApplicant(String rentalID, String tenantID) {
     
    }

    public void sendApprovalNotification(String tenantID, String details) {
      
    }
}
