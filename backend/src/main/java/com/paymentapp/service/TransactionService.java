package com.paymentapp.service;

import com.paymentapp.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TransactionService {

    public List<Transaction> getAllTransactions() {
        return Arrays.asList(
            new Transaction("1", "Zara",          "Shopping",    120.00, "2026-04-15"),
            new Transaction("2", "McDonald's",    "Food",         18.50, "2026-04-16"),
            new Transaction("3", "Shell",         "Fuel",         65.00, "2026-04-16"),
            new Transaction("4", "Netflix",       "Entertainment", 15.98, "2026-04-17"),
            new Transaction("5", "H&M",           "Shopping",     85.00, "2026-04-18"),
            new Transaction("6", "KFC",           "Food",         22.00, "2026-04-18"),
            new Transaction("7", "Spotify",       "Entertainment", 9.99, "2026-04-19"),
            new Transaction("8", "Cold Storage",  "Groceries",    95.40, "2026-04-20"),
            new Transaction("9", "NTUC FairPrice", "Groceries",   62.30, "2026-04-20"),
            new Transaction("10","Starbucks",     "Food",         12.50, "2026-04-21")
        );
    }
}
