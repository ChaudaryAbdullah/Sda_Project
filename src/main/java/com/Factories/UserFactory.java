package com.Factories;

import com.BussinessLogic.classes.Applicant;
import com.BussinessLogic.classes.Owner;
import com.BussinessLogic.classes.Tenant;

public class UserFactory {
    @SuppressWarnings("unused")
    private static String generateUniqueID() {
        return "USER-" + System.currentTimeMillis();
    }

    public static Tenant createTenant(int ID, String username, String firstname, String lastname, String address, String dob, String password) {
        return new Tenant(ID, username, firstname, lastname, address, dob, password);
    }

    public Owner createOwner(int ID, String username, String firstname, String lastname, String address, String dob, String password) {

        return new Owner(ID, username, firstname, lastname, address, dob, password);
    }

    public Applicant createApplicant(int ID, String username, String firstname, String lastname, String address, String dob, String password) {
        return new Applicant(ID, username, firstname, lastname, address, dob, password);
    }
}
