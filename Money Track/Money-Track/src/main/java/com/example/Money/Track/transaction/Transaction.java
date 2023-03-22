package com.example.Money.Track.transaction;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
public class Transaction {

    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy= SEQUENCE,
            generator = "transaction_sequence")
    private Long id;
    private String category;
    private Double amount;
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(Long id, String category, Double amount, LocalDate date) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type='" + category + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
