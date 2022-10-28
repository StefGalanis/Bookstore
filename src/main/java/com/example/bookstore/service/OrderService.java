package com.example.bookstore.service;

import com.example.bookstore.model.Order;
import com.example.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return this.orderRepository.findAll();
    }

    public Order getOrderWithId(Long id){
        Optional<Order> optionalOrder = this.orderRepository.findById(id);
        Order order = null;
        if (optionalOrder.isPresent()){
            order = optionalOrder.get();
        }
        else{
            throw new RuntimeException("Could not find order with Id :: " + id);
        }
        return order;
    }

    public void createOrder(Order order){
        this.orderRepository.save(order);
    }

//    public List<Order> getOrdersWithCustomerId(Long customer_id){
//        Optional<Order> optionalOrderList = orderRepository;
//        List<Order> orderList = null;
//        if (optionalOrderList.isPresent()){
//            orderList = optionalOrderList.get();
//        }
//    }
}
