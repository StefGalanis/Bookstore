package com.example.bookstore.controller;


import com.example.bookstore.model.Book;
import com.example.bookstore.model.Order;
import com.example.bookstore.model.OrderBook;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.OrderBookService;
import com.example.bookstore.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderBookController {

    private final OrderBookService orderBookService;
    private final OrderService orderService;
    private final BookService bookService;

    public OrderBookController(OrderBookService orderBookService, OrderService orderService, BookService bookService) {
        this.orderBookService = orderBookService;
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @GetMapping("/deleteOrderBookWithId/{id}")
    public String deleteOrderBookWithId(@PathVariable(name = "id") Long id, Model model){
        Long customer_id = this.orderBookService.getOrderBookWithId(id).getOrder().getId();
        this.orderBookService.deleteOrderBookById(id);
        return "redirect:/showOrder/" + "" +customer_id;
    }

    @GetMapping("/addToOrder/{order_id}/{book_id}")
    public String createOrderBookWithId(@PathVariable(name = "order_id") Long order_id,
                                        @PathVariable(name = "book_id") Long book_id, Model model){
        Order order = this.orderService.getOrderWithId(order_id);
        Book book = this.bookService.getBookWithId(book_id);
        OrderBook orderBook = new OrderBook(order,book);
        this.orderBookService.createOrderBook(orderBook);
        return "redirect:/showOrder/"+ "" + order.getId();
    }
}
