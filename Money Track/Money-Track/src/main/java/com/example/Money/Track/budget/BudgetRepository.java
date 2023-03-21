package com.example.Money.Track.budget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    @Query("SELECT b FROM budget b WHERE b.budgetName = ?1")
    Optional<Budget> findBudgetByName(String name);


    //create query for searching by date

}
