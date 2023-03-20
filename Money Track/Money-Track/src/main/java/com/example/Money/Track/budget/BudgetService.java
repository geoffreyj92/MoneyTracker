package com.example.Money.Track.budget;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public Optional<Budget> getBudgetById(Long id) {
        return budgetRepository.findById(id);
    }

    public Budget newBudget(Budget budget) {
        Optional<Budget> newBudget = budgetRepository.findBudgetByName(budget.getBudgetName());

        if (newBudget.isPresent()) {
            throw new IllegalStateException("Budget already exists");
        } else if (budget.getAmount() < 0) {
            throw new RuntimeException("Amount must be greater than 0");
        }
         return budgetRepository.saveAndFlush(budget);


//        if (amount >= 0) {
//            budget.setAmount(amount);
//        } else {
//            throw new RuntimeException("Amount must be greater than 0");
//        }

    }
}
