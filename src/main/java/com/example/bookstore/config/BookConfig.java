package com.example.bookstore.config;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner bookSeeder(BookRepository repository){
        return args -> {

            Book book1 = new Book(
                    "The Wicther",
                    "Andrzej Sapkowski",
                    1990
            );

            Book book2 = new Book(
                    "Sword of Destiny",
                    "Andrzej Sapkowski",
                    2015
            );

            repository.saveAll(
                    List.of(book1, book2)
            );
        };
    }
}
