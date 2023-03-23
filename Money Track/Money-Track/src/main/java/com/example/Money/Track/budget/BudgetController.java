package com.example.Money.Track.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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


    @PutMapping("/{id}")
    public boolean updateBudget(@RequestBody Budget budget, @PathVariable Long id) {
        boolean updated = true;

        if (updated) {

            budgetService.updateBudget(budget, id);
            return true;
        }

        return false;


    }


    //search by date range
}
