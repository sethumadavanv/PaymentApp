package com.paymentapp.model;

public class Offer {
    private String id;
    private String title;
    private String description;
    private String category;
    private String discount;

    public Offer(String id, String title, String description, String category, String discount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.discount = discount;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getDiscount() { return discount; }
}
