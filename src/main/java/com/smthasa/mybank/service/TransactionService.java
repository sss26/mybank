package com.smthasa.mybank.service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.smthasa.mybank.model.Transaction;

@Component
public class TransactionService {

    private final String bankSlogan;

    List<Transaction> transactions = new CopyOnWriteArrayList<Transaction>();

    public TransactionService(@Value("${bank.slogan}") String bankSlogan) {
        this.bankSlogan = bankSlogan;
    }

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction create(BigDecimal amount, String reference) {
        ZonedDateTime timestamp = ZonedDateTime.now();
        Transaction transaction = new Transaction(amount, timestamp, reference, bankSlogan);
        transactions.add(transaction);
        return transaction;
    }
}
