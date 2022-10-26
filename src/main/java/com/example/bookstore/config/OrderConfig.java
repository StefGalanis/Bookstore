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
                    1954
            );

            Book book2 = new Book(
                    "The Lord of the Rings: The Two Towers",
                    "J. R. R. Tolkien",
                    1954
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
