package com.thienantran.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.thienantran.context.ApplicationConfiguration;
import com.thienantran.model.Transaction;
import com.thienantran.service.TransactionService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionServlet extends HttpServlet{

    private ObjectMapper objectMapper;
    private TransactionService transactionService;

    @Override
    public void init() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        this.objectMapper = ctx.getBean(ObjectMapper.class);
        this.transactionService = ctx.getBean(TransactionService.class);

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
            JsonNode jsonNode = objectMapper.readTree(request.getInputStream());
            String userId = jsonNode.path("userId").asText(null);

            CopyOnWriteArrayList<Transaction> userTransactions = transactionService.findUserTransactions(userId);

            String json = objectMapper.writeValueAsString(userTransactions);

            response.getWriter().print(json);
        }

        else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
            JsonNode jsonNode = objectMapper.readTree(request.getInputStream());

            Integer amount = jsonNode.path("amount").asInt(-1);
            String userId = jsonNode.path("userId").asText(null);
            String reference = jsonNode.path("reference").asText(null);

            Transaction transaction = transactionService.create(amount, userId, reference);

            String json = objectMapper.writeValueAsString(transaction);

            response.getWriter().print(json);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
