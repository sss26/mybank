package com.smthasa.mybank.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Transaction {

    private String id;
    private int amount;
    private String timeStamp;
    private String reference;
    private String slogan;

    public Transaction() {

    }

    public Transaction(String id, int amount, String reference, String slogan) {
        this.id = id;
        this.amount = amount;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        df.setTimeZone(TimeZone.getTimeZone("PST"));
        this.timeStamp = df.format(new Date());
        this.reference = reference;
        this.slogan = slogan;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getReference() {
        return reference;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

}
