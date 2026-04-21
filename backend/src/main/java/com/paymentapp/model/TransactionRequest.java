package com.paymentapp.model;

public class TransactionRequest {
    private String merchant;
    private String category;
    private double amount;
    private String date;

    public String getMerchant() { return merchant; }
    public String getCategory() { return category; }
    public double getAmount()   { return amount; }
    public String getDate()     { return date; }
}
