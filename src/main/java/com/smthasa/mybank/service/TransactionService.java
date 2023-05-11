package com.smthasa.mybank.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.smthasa.mybank.model.Transaction;

public class TransactionService {

	List<Transaction> transactions = new CopyOnWriteArrayList<Transaction>();

	public Transaction create(String id, int amount, String reference) {
		Transaction transaction = new Transaction(id, amount, reference);
		transactions.add(transaction);
		return transaction;
	}

	public List<Transaction> findAll() {
		return transactions;
	}

}
