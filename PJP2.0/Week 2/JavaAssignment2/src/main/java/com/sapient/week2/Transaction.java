package com.sapient.week2;

import java.time.LocalDate;

public class Transaction {
    private String ID;
    private String clientID;
    private String securityID;
    private String type;
    private LocalDate date;
    private Double value;
    private Boolean priority;
    private Double fee;

    public Boolean isPriority() {
        return this.priority;
    }

    public Boolean getPriority() {
        return this.priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public Double getFee() {
        return this.fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getClientID() {
        return this.clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getSecurityID() {
        return this.securityID;
    }

    public void setSecurityID(String securityID) {
        this.securityID = securityID;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}