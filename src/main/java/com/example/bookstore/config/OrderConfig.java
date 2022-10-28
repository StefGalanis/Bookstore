package com.example.bookstore.config;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Customer;
import com.example.bookstore.model.Order;
import com.example.bookstore.model.OrderBook;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CustomerRepository;
import com.example.bookstore.repository.OrderBookRepository;
import com.example.bookstore.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OrderConfig {


    @Bean
    CommandLineRunner orderSeeder(OrderRepository repository,
                                  CustomerRepository customerRepository,
                                  OrderBookRepository orderBookRepository,
                                  BookRepository bookRepository){
        return args -> {

            Customer customer1 = new Customer("Marios","marios@gmail.com",19);
            Customer customer2 = new Customer("giorgos","giorgos@gmail.com",19);
            customerRepository.saveAll(List.of(customer1,customer2));

            Book book1 = new Book(
                    "The Lord of the Rings: The Fellowship of the Ring",
                    "J. R. R. Tolkien",
                    1954,
                    " Continuing the story begun in The Hobbit, this is the first part of Tolkien's epic masterpiece, The Lord of the Rings, featuring a striking black cover based on Tolkien's own design, the definitive text, and a detailed map of Middle-earth.\n" +
                            "\n" +
                            "Sauron, the Dark Lord, has gathered to him all the Rings of Power - the means by which he intends to rule Middle-earth. All he lacks "
            );

            Book book2 = new Book(
                    "The Lord of the Rings: The Two Towers",
                    "J. R. R. Tolkien",
                    1954,
                    "Continuing the story of The Hobbit, this is the second part of Tolkien's epic masterpiece, The Lord of the Rings, featuring an exclusive cover image from the film, the definitive text, and a detailed map of Middle-earth. Frodo and the Companions of the Ring have been beset by danger during their quest to prevent the Ruling Ring from falling into the hands of the Dark Lord by destroying it in the "
            );

            bookRepository.saveAll(List.of(book1,book2));

            Order order1 = new Order(
                    1L,
                    customer1
            );

            Order order2 = new Order(
                    2L,
                    customer2
            );

            repository.saveAll(
                    List.of(order1, order2)
            );

            OrderBook orderBook1 = new OrderBook(
                    order1,
                    book1,
                    1
            );

            OrderBook orderBook2 = new OrderBook(
                    order1,
                    book2,
                    1
            );

            orderBookRepository.saveAll(List.of(orderBook1,orderBook2));
        };
    }
}
