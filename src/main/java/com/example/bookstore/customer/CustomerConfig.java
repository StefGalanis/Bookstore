package com.example.bookstore.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args -> {

            Customer steven = new Customer(
                    "Steven",
                    "steven@gmail.com",
                    29
            );

            Customer steph = new Customer(
                    "Steph",
                    "steph@gmail.com",
                    25
            );

            repository.saveAll(
                    List.of(steven, steph)
            );
        };
    }
}
