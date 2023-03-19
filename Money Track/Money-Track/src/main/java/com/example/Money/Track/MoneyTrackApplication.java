package com.example.Money.Track;

import com.example.Money.Track.budget.Budget;
import com.example.Money.Track.budget.BudgetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class MoneyTrackApplication {

	private static final Logger log = LoggerFactory.getLogger(MoneyTrackApplication.class);



	public static void main(String[] args) {
		SpringApplication.run(MoneyTrackApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BudgetRepository repository) {
		return args -> {
			Budget budget = new Budget("March", 500.00, LocalDate.now(), LocalDate.of(2023, Month.MARCH, 25));
			Budget budget1 = new Budget("March", 500.00, LocalDate.now(), LocalDate.of(2023, Month.APRIL, 25));
			Budget budget2 = new Budget("March", 500.00, LocalDate.now(), LocalDate.of(2023, Month.JULY, 30));
			Budget budget3 = new Budget("March", 500.00, LocalDate.now(), LocalDate.of(2023, Month.JUNE, 5));
			Budget budget4 = new Budget("March", 500.00, LocalDate.now(), LocalDate.of(2023, Month.SEPTEMBER, 2));
			Budget budget5 = new Budget("March", 500.00, LocalDate.now(), LocalDate.of(2023, Month.OCTOBER, 25));

			repository.saveAll(List.of(budget, budget1, budget2, budget3, budget4, budget5));
		};
	}

}