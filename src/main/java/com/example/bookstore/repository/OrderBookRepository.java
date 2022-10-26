package com.example.bookstore.repository;

import com.example.bookstore.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {
    @Query(value = "SELECT * FROM order_book WHERE order_id = ?1",nativeQuery = true)
    List<OrderBook> getOrderBookByOrderId(Long id);
}
