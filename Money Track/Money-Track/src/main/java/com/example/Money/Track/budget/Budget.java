package com.example.Money.Track.budget;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;

import java.time.LocalDate;
@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String budgetName;
    private Double amount;
    private LocalDate startDate;
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
