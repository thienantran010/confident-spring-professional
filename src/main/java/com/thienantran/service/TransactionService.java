package com.thienantran.service;

import com.thienantran.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TransactionService {

    private final CopyOnWriteArrayList<Transaction> transactions;
    private final String slogan;
    public TransactionService(CopyOnWriteArrayList<Transaction> transactions, @Value("${bank.slogan}") String slogan) {
        this.transactions = transactions;
        this.slogan = slogan;
    }

    public Transaction create(Integer amount, String userId, String reference) {
        Transaction transaction = new Transaction(amount, userId, reference + slogan);
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
