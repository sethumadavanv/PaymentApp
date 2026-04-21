package com.paymentapp.model;

public class Transaction {
    private String id;
    private String merchant;
    private String category;
    private double amount;
    private String date;

    public Transaction(String id, String merchant, String category, double amount, String date) {
        this.id = id;
        this.merchant = merchant;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String getId() { return id; }
    public String getMerchant() { return merchant; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
}
