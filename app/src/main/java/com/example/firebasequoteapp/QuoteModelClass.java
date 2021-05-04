package com.example.firebasequoteapp;

public class QuoteModelClass {
    private String aurthor ,description;

    public QuoteModelClass(String aurthor, String description) {
        this.aurthor = aurthor;
        this.description = description;
    }

    public QuoteModelClass() {
    }

    public String getAurthor() {
        return aurthor;
    }

    public void setAurthor(String aurthor) {
        this.aurthor = aurthor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
