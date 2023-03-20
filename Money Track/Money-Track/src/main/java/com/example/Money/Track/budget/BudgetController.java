package com.example.Money.Track.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public void newBudget(@RequestBody Budget budget) {
        budgetService.newBudget(budget);
    }

    //add update by id method


    //search by date range
}
