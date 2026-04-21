package com.paymentapp.model;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String merchant;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String date;

    protected Transaction() {}

    public Transaction(String merchant, String category, double amount, String date) {
        this.merchant = merchant;
        this.category = category;
        this.amount   = amount;
        this.date     = date;
    }

    public Long getId()        { return id; }
    public String getMerchant(){ return merchant; }
    public String getCategory(){ return category; }
    public double getAmount()  { return amount; }
    public String getDate()    { return date; }
}
