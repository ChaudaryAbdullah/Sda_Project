package com.HandlersPackage;

import com.Factories.FinesFactory;

public class FinesOwnerHandler {
    private final FinesDAO finesDAO;

    public FinesOwnerHandler() {
        finesDAO = new FinesDAO();
    }

    public void newFine(int fineID, String issueDate,String Reason, int amount, int ownerID, int tenatID) {
        FinesFactory.createFines(fineID, issueDate, Reason, amount, ownerID, tenatID);

        finesDAO.addFine(issueDate, Reason, amount, ownerID, tenatID);
    }
}
