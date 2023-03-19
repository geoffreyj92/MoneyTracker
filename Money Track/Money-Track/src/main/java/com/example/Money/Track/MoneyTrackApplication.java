package com.example.Money.Track;

import com.example.Money.Track.budget.Budget;
import com.example.Money.Track.budget.BudgetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class MoneyTrackApplication {

	private static final Logger log = LoggerFactory.getLogger(MoneyTrackApplication.class);



	public static void main(String[] args) {
		SpringApplication.run(MoneyTrackApplication.class, args);
	}

	CommandLineRunner commandLineRunner(BudgetRepository repository) {
		return args -> {
			Budget budget = new Budget("March", 500.00, LocalDate.now(), LocalDate.of());
		};
	}

}