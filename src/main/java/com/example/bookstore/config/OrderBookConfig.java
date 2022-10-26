package com.example.bookstore.config;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Order;
import com.example.bookstore.model.OrderBook;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.OrderBookRepository;
import com.example.bookstore.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OrderBookConfig {

//    @Bean
//    CommandLineRunner orderBookSeeder(OrderBookRepository repository){
//        return args -> {
//
//
//            Order order1 = new Order("someone1@gmail.com");
//            Order order2 = new Order("someone@gmail.com");
//            OrderRepository.saveAll(List.of(order1,order2));
//            Book book = new Book("The stars","kodwe",1999);
//            bookRepository.save(book);
//
//
//
//            OrderBook orderBook1 = new OrderBook(
//                    1L,
//                    order2,
//                    book,
//                    2
//            );
//
//            OrderBook orderBook2 = new OrderBook(
//                    2L,
//                    order1,
//                    book,
//                    3
//            );
//
//            repository.saveAll(
//                    List.of(orderBook1, orderBook2)
//            );
//        };
//    }
}
