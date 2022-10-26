package com.example.bookstore.service;

import com.example.bookstore.model.OrderBook;
import com.example.bookstore.repository.OrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
