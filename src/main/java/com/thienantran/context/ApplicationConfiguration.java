package com.thienantran.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thienantran.model.Transaction;
import com.thienantran.service.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CopyOnWriteArrayList;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TransactionService getTransactionService(CopyOnWriteArrayList<Transaction> transactions) {
        return new TransactionService();
    }

    @Bean
    public CopyOnWriteArrayList<Transaction> getDB() {
        return new CopyOnWriteArrayList<Transaction>();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
