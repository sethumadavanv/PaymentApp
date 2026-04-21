package com.paymentapp.service;

import com.paymentapp.model.Offer;
import com.paymentapp.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OfferService {

    @Autowired
    private TransactionService transactionService;

    private static final Map<String, Offer> OFFER_CATALOG = new HashMap<>();

    static {
        OFFER_CATALOG.put("Shopping",      new Offer("O1", "10% off at Zara",        "Spend $100+ at Zara this weekend",       "Shopping",      "10%"));
        OFFER_CATALOG.put("Food",          new Offer("O2", "Free dessert at KFC",     "Buy any meal, get a free dessert",       "Food",          "Free item"));
        OFFER_CATALOG.put("Fuel",          new Offer("O3", "5% cashback on fuel",     "At Shell stations this month",           "Fuel",          "5% cashback"));
        OFFER_CATALOG.put("Entertainment", new Offer("O4", "2 months free on Disney+","Bundle your subscriptions and save",     "Entertainment", "2 months free"));
        OFFER_CATALOG.put("Groceries",     new Offer("O5", "$10 off groceries",       "Spend $80+ at Cold Storage or NTUC",     "Groceries",     "$10 off"));
    }

    public List<Offer> getPersonalisedOffers() {
        List<Transaction> transactions = transactionService.getAllTransactions();

        // Aggregate spend by category
        Map<String, Double> spendByCategory = transactions.stream()
            .collect(Collectors.groupingBy(
                Transaction::getCategory,
                Collectors.summingDouble(Transaction::getAmount)
            ));

        // Sort categories by spend descending, return top 3 offers
        return spendByCategory.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .limit(3)
            .filter(e -> OFFER_CATALOG.containsKey(e.getKey()))
            .map(e -> OFFER_CATALOG.get(e.getKey()))
            .collect(Collectors.toList());
    }
}
