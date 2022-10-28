package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Customer;
import com.example.bookstore.model.Order;
import com.example.bookstore.model.OrderBook;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.CustomerService;
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
    private final CustomerService customerService;
    private final BookService bookService;

    public OrderController(OrderService orderService, OrderBookService orderBookService,
                           CustomerService customerService,BookService bookService) {
        this.orderService = orderService;
        this.orderBookService = orderBookService;
        this.customerService = customerService;
        this.bookService = bookService;
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

    @GetMapping("/createOrder/{id}")
    public String createOrder(@PathVariable (value = "id") Long id, Model model){
        Customer customer = this.customerService.getCustomerById(id);
        Order order = new Order(customer);
        this.orderService.createOrder(order);
        model.addAttribute("order_id",order.getId());
        List<Book> bookList = this.bookService.getAllBooks();
        model.addAttribute("books", bookList);
//        return "redirect:/showOrder/"+ "" + order.getId();
        return "create_order";
    }
}
