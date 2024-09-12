package com.thienantran.web;

import com.thienantran.model.Transaction;
import com.thienantran.service.TransactionService;
import com.thienantran.web.forms.CreateTransactionForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class WebsiteController {
    private TransactionService transactionService;
    public WebsiteController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("/")
    public String homepage() {
        return "index.html";
    }
    @GetMapping("/transactions/{userId}")
    public String getUserTransactions(Model model, @PathVariable String userId) {
        CopyOnWriteArrayList<Transaction> transactions = transactionService.findUserTransactions(userId);
        model.addAttribute("transactions", transactions);
        model.addAttribute("createTransactionForm", new CreateTransactionForm());
        return "userTransactions.html";
    }

    @PostMapping("/transactions/create")
    public String postTransaction(@ModelAttribute @Valid CreateTransactionForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }
        transactionService.create(form.getAmount(), form.getUserId(), form.getReference());
        return "redirect:/transactions/" + form.getUserId();
    }

}
