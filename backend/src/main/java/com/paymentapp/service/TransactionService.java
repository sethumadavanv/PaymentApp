package com.paymentapp.service;

import com.paymentapp.model.Transaction;
import com.paymentapp.model.TransactionRequest;
import com.paymentapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TransactionService implements CommandLineRunner {

    @Autowired
    private TransactionRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.saveAll(Arrays.asList(
                new Transaction("Zara",           "Shopping",     120.00, "2026-04-15"),
                new Transaction("McDonald's",     "Food",          18.50, "2026-04-16"),
                new Transaction("Shell",          "Fuel",          65.00, "2026-04-16"),
                new Transaction("Netflix",        "Entertainment", 15.98, "2026-04-17"),
                new Transaction("H&M",            "Shopping",      85.00, "2026-04-18"),
                new Transaction("KFC",            "Food",          22.00, "2026-04-18"),
                new Transaction("Spotify",        "Entertainment",  9.99, "2026-04-19"),
                new Transaction("Cold Storage",   "Groceries",     95.40, "2026-04-20"),
                new Transaction("NTUC FairPrice", "Groceries",     62.30, "2026-04-20"),
                new Transaction("Starbucks",      "Food",          12.50, "2026-04-21")
            ));
        }
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction addTransaction(TransactionRequest request) {
        Transaction tx = new Transaction(
            request.getMerchant(),
            request.getCategory(),
            request.getAmount(),
            request.getDate()
        );
        return repository.save(tx);
    }
}
