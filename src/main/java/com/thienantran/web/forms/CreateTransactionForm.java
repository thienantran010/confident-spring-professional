package com.thienantran.web.forms;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateTransactionForm {
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Min(1)
    private int amount;

    @NotBlank
    private String userId, reference;
}
