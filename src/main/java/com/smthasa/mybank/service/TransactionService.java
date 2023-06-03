package com.smthasa.mybank.service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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

    public List<Transaction> findByReceivingUserId(String userId) {
        List<Transaction> userTransactions = new ArrayList<Transaction>();
        for (Transaction trans : transactions) {
            if (trans.getReceivingUser().equals(userId)) {
                userTransactions.add(trans);
            }
        }
        return userTransactions;
    }

    public Transaction create(BigDecimal amount, String reference, String receivingUser) {
        ZonedDateTime timestamp = ZonedDateTime.now();
        Transaction transaction = new Transaction(amount, timestamp, reference, bankSlogan, receivingUser);
        transactions.add(transaction);
        return transaction;
    }
}
