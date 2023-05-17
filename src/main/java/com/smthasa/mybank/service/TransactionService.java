package com.smthasa.mybank.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.smthasa.mybank.model.Transaction;

@Component
public class TransactionService {

    private final String slogan;

    List<Transaction> transactions = new CopyOnWriteArrayList<Transaction>();

    public TransactionService(@Value("${bank.slogan}") String slogan) {
        this.slogan = slogan;
    }

    public Transaction create(String id, int amount, String reference) {
        Transaction transaction = new Transaction(id, amount, reference, slogan);
        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> findAll() {
        return transactions;
    }

}
