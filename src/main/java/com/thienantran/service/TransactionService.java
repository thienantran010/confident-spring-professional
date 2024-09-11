package com.thienantran.service;

import com.thienantran.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TransactionService {

    private final CopyOnWriteArrayList<Transaction> transactions;
    public TransactionService(CopyOnWriteArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Transaction create(Integer amount, String userId, String reference) {
        Transaction transaction = new Transaction(amount, userId, reference);
        transactions.add(transaction);
        return transaction;
    }

    public LinkedList<Transaction> findUserTransactions(String userId) {
        LinkedList<Transaction> userTransactions = new LinkedList<Transaction>();

        for (Transaction transaction : transactions) {
            if (transaction.getUserId().equals(userId)) {
                userTransactions.add(transaction);
            }
        }
        return userTransactions;
    }
}
