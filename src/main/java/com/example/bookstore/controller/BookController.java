package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String updateBook(Book book){
        Optional<Book> bookData = Optional.ofNullable(bookService.getBookWithId(book.getId()));

        if (bookData.isPresent()) {
            Book _book = bookData.get();
            _book.setTitle(book.getTitle());
            _book.setAuthor(book.getAuthor());
            _book.setYear(book.getYear());
            _book.setDescription(book.getDescription());
            bookService.updateBook(_book);
        } else {
            throw new RuntimeException("Could not update book with id ::" + book.getId());
        }
        return "redirect:/Books";
    }

    @GetMapping("/deleteBookWithId/{id}")
    public String deleteBookWithId(@PathVariable (value = "id") Long id, Model model){
        bookService.deleteBook(id);
        return "redirect:/Books";
    }

    @GetMapping("showBook/{id}")
    public String showBookWithId(@PathVariable(name = "id") long id,Model model){
        Book book = this.bookService.getBookWithId(id);
        model.addAttribute(book);
        return "show_book";
    }

    @GetMapping("/showCreateBookForm")
    public String showCreateForm(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "create_book";
    }

    @PostMapping("/createBook")
    public String createBook(Book book){
        this.bookService.createBook(book);
        return "redirect:/Books";
    }

}
