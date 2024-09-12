package com.thienantran.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

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

    @Min(1)
    private int amount;

    @NotBlank
    private String userId, reference;
}
