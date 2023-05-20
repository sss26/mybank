package com.smthasa.mybank.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smthasa.mybank.model.Transaction;
import com.smthasa.mybank.service.TransactionService;

@RestController
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        List<Transaction> transactions = transactionService.findAll();
        return transactions;
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestParam double amount, @RequestParam String reference) {
        BigDecimal bigAmount = BigDecimal.valueOf(amount);
        Transaction transaction = transactionService.create(bigAmount, reference);
        return transaction;
    }
}
