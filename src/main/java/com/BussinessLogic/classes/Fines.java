package com.BussinessLogic.classes;

public class Fines {
    int fineId;
	String issueDate;
	String reason;
	int amount;
	int ownerId;
	int tenantId;

    public Fines(int fineId, String issueDate, String reason, int amount, int ownerId, int tenantId){
        this.fineId = fineId;
        this.issueDate = issueDate;
        this.reason = reason;
        this.amount = amount;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
    }

    // Getters
    public int getFineId() {
        return fineId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getReason() {
        return reason;
    }

    public int getAmount() {
        return amount;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getTenantId() {
        return tenantId;
    }

    // Setters
    public void setFineId(int fineId) {
        this.fineId = fineId;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }
    
}
