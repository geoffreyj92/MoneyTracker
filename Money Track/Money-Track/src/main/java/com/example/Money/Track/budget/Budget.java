package com.example.Money.Track.budget;

import jakarta.persistence.*;
import jdk.jfr.Enabled;


import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "budget")
public class Budget {

    @Id
    @SequenceGenerator(
            name = "budget_sequence",
            sequenceName = "budget_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy= SEQUENCE,
            generator = "budget_sequence")

    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "budgetName", nullable = false, columnDefinition = "TEXT")
    private String budgetName;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;

    protected Budget() {
    }

    public Budget(String budgetName, Double amount, LocalDate startDate, LocalDate endDate) {
        this.budgetName = budgetName;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", budgetName='" + budgetName + '\'' +
                ", amount=" + amount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
