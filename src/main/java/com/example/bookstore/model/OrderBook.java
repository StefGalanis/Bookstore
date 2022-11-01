package com.example.bookstore.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "order_book")
public class OrderBook {

//    two foreign keys as primary
    @Id
    @SequenceGenerator(
            name = "order_book_sequence",
            sequenceName = "order_book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_book_sequence"
    )
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    private Integer quantity;


    public OrderBook() {
    }

    public OrderBook(Order order, Book book) {
        this.order = order;
        this.book = book;
        this.quantity = 1;
    }

    public OrderBook(Order order, Book book, Integer quantity) {
        this.order = order;
        this.book = book;
        this.quantity = quantity;
    }

    public OrderBook(Long id, Order order, Book book, Integer quantity) {
        this.id = id;
        this.order = order;
        this.book = book;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "id=" + id +
                ", order=" + order +
                ", book=" + book +
                ", quantity=" + quantity +
                '}';
    }
}
