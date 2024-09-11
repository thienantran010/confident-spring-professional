package com.thienantran.model;

import java.util.UUID;

import java.time.ZonedDateTime;
import java.time.ZoneOffset;


public class Transaction {
    private Integer amount;
    private String id, userId, timestamp, reference;

    public Transaction(Integer amount, String userId, String reference) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.timestamp = ZonedDateTime.now(ZoneOffset.UTC).toString();
        this.amount = amount;
        this.reference = reference;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
