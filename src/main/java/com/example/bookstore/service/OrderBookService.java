package com.example.bookstore.service;

import com.example.bookstore.model.Order;
import com.example.bookstore.model.OrderBook;
import com.example.bookstore.repository.OrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderBookService {

    private final OrderBookRepository orderBookRepository;

    @Autowired
    public OrderBookService(OrderBookRepository orderBookRepository) {
        this.orderBookRepository = orderBookRepository;
    }

    public List<OrderBook> getAllOrderBooksWithOrderId(Long id){
        return this.orderBookRepository.getOrderBookByOrderId(id);
    }

    public OrderBook getOrderBookWithId(Long id){
        Optional<OrderBook> optionalOrderBook = this.orderBookRepository.findById(id);
        OrderBook orderBook = null;
        if (optionalOrderBook.isPresent()){
            orderBook = optionalOrderBook.get();
        }
        else{
            throw new RuntimeException("Could not find orderBook with Id :: "+ id);
        }
        return orderBook;
    }

    public void deleteOrderBookById(Long id){
        this.orderBookRepository.deleteById(id);
    }

    public void deleteOrderBook(OrderBook orderBook){
        this.orderBookRepository.delete(orderBook);
    }

    public void createOrderBook(OrderBook orderBook){
        this.orderBookRepository.save(orderBook);
    }

    public List<OrderBook> getOrderBookWithBookId(Long id){
        return this.orderBookRepository.getOrderBookByBookId(id);
    }

    public void saveOrderBook(OrderBook orderBook){
        this.orderBookRepository.save(orderBook);
    }
}
