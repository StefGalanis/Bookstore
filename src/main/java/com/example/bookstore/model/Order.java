package com.example.bookstore.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;


    @OneToMany(mappedBy = "order")
    private Set<OrderBook> orderBookSet = new HashSet<>();

    public Order() {
    }

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Order(Long id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public Order(Long id, Customer customer,Set<OrderBook> orderBookSet) {
        this.id = id;
        this.customer = customer;
        this.orderBookSet = orderBookSet;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderBook> getOrderBookSet() {
        return orderBookSet;
    }

    public void setOrderBookSet(Set<OrderBook> orderBookSet) {
        this.orderBookSet = orderBookSet;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                '}';
    }
}
