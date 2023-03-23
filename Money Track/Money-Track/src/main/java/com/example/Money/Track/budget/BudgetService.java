package com.example.Money.Track.budget;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import javax.swing.text.html.Option;
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

        //Add relation for adding transactions to budgets


//        if (amount >= 0) {
//            budget.setAmount(amount);
//        } else {
//            throw new RuntimeException("Amount must be greater than 0");
//        }

    }

    public Budget updateBudget(Budget budget, Long id) {

        if (budgetRepository.findById(id).isPresent()) {
            budget.setBudgetName(budget.getBudgetName());
            budget.setAmount(budget.getAmount());
            budget.setStartDate(budget.getStartDate());
            budget.setEndDate(budget.getEndDate());
        } else {
            throw new RuntimeException("This id does not exist");
        }

         return budgetRepository.save(budget);
    }
}
