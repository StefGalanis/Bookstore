package com.example.bookstore.controller;

import com.example.bookstore.model.Order;
import com.example.bookstore.model.OrderBook;
import com.example.bookstore.service.OrderBookService;
import com.example.bookstore.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;
    private OrderBookService orderBookService;

    public OrderController(OrderService orderService, OrderBookService orderBookService) {
        this.orderService = orderService;
        this.orderBookService = orderBookService;
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model){
        List<Order> orders = this.orderService.getAllOrders();
        model.addAttribute("orders",orders);
        return "orders";
    }

    @GetMapping("/showOrder/{id}")
    public String showOrder(@PathVariable (value = "id") Long id, Model model){
        Order order = this.orderService.getOrderWithId(id);
        model.addAttribute("order",order);
        List<OrderBook> orderBookList = this.orderBookService.getAllOrderBooksWithOrderId(id);
        model.addAttribute("orderBookList",orderBookList);
        return "show_order";
    }
}
