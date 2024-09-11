package com.thienantran.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thienantran.ApplicationLauncher;
import com.thienantran.model.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CopyOnWriteArrayList;

@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@Configuration
public class ApplicationConfiguration {

    @Bean
    public CopyOnWriteArrayList<Transaction> getDB() {
        return new CopyOnWriteArrayList<Transaction>();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
