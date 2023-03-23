package com.example.Money.Track.transaction;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAll() {
        return repository.findAll();
    };

    public Optional<Transaction> findById(Long id) {
        return repository.findById(id);
    }

    public void newTransaction(Transaction transaction) {
        //search for transaction if exists. If does not exist, try to create transaction

    }
}
