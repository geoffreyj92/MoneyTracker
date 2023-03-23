package com.example.Money.Track.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);

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

    public Transaction newTransaction(Transaction transaction) {
        //search for transaction if exists. If does not exist, try to create transaction.
        Optional<Transaction> newTransaction = repository.findTransactionId(transaction.getId());

        if (newTransaction.isPresent()) {
            throw new IllegalStateException("transaction already exists");
        } else if (transaction.getAmount() < 0) {
            throw new RuntimeException("Amount must be greater than or equal to 0");
        } else {
            try {
                transaction.setAmount(transaction.getAmount());
                transaction.setDate(transaction.getDate());
                transaction.setCategory(transaction.getCategory());
            } catch (ResourceAccessException e) {
                log.info(e.getMessage());
            }
        }
        return transaction;


    }
}
