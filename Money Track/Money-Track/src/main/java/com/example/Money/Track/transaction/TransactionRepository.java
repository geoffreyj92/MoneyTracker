package com.example.Money.Track.transaction;

import com.example.Money.Track.budget.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM budget t WHERE t.id = ?1")
    Optional<Transaction> findTransactionId(Long id);
}
