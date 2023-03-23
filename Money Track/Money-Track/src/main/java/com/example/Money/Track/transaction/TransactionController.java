package com.example.Money.Track.transaction;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Transaction> findById(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @PostMapping("/all")
    public Transaction newTransaction(@RequestBody Transaction transaction) {

            transactionService.newTransaction(transaction);

        return transaction;
    }
}
