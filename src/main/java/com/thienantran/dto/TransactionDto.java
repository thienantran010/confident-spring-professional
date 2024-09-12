package com.thienantran.dto;

public class TransactionDto {
    public int getAmount() {
        return amount;
    }

    public String getUserId() {
        return userId;
    }

    public String getReference() {
        return reference;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    private int amount;
    private String userId, reference;
}
