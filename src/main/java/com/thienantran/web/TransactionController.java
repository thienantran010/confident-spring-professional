package com.thienantran.web;

import com.thienantran.dto.TransactionDto;
import com.thienantran.dto.UserDto;
import com.thienantran.model.Transaction;
import com.thienantran.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    @ResponseBody
    public CopyOnWriteArrayList<Transaction> getTransactions(@RequestBody @Valid UserDto userDto) {
        return transactionService.findUserTransactions(userDto.getUserId());
    }
}
