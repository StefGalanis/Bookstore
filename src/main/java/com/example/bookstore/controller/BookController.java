package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Customer;
import com.example.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/Books")
    public String showBooks(Model model,Book book){
        List<Book> bookList = bookService.getAllBooks();
        model.addAttribute("books", bookList);
        return "books";
    }

    @GetMapping("/showBookUpdateForm/{id}")
    public String showBookUpdateForm(@PathVariable (value = "id") long id, Model model){
        Book book = bookService.getBookWithId(id);
        model.addAttribute("book", book);
        return "update_book";
    }

    @PostMapping("/updateBook")
    public String updateBook(Book book, Model model){
        bookService.updateBook(book);
        return "redirect:/Books";
    }

    @GetMapping("/deleteBookWithId/{id}")
    public String deleteBookWithId(@PathVariable (value = "id") Long id, Model model){
        bookService.deleteBook(id);
        return "redirect:/Books";
    }


//    @GetMapping("/showNewCustomerForm")
//    public String showNewCustomerForm(Model model){
//        Customer customer = new Customer();
//        model.addAttribute("customer", customer);
//        return "new_customer";
//    }

}
