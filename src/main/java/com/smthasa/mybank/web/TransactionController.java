package com.smthasa.mybank.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smthasa.mybank.dto.TransactionDto;
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
    public Transaction createTransaction(@RequestBody TransactionDto transactionDto) {
        Transaction transaction = transactionService.create(transactionDto.getAmount(), transactionDto.getReference());
        return transaction;
    }
}
