package com.example.Money.Track.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/budget")
public class BudgetController {

    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;

    }

    @GetMapping("/")
    public List<Budget> getAllBudgets() {
       return budgetService.getAllBudgets();
    }

    @GetMapping("/{id}")
    public Optional<Budget> getBudgetById(@PathVariable(name = "id") Long id) {
        return budgetService.getBudgetById(id);
    }
}
