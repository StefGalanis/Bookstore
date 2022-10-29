package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    public void deleteBook(Long id){
        this.bookRepository.deleteById(id);
    }

    public void updateBook(Book book){
        this.bookRepository.save(book);
    }

    public Book getBookWithId(Long id){
        Optional<Book> bookOptional = this.bookRepository.findById(id);
        Book book = null;
        if(bookOptional.isPresent()){
            book = bookOptional.get();
        }
        else{
            throw new RuntimeException("Book not found by ID :: " + id);
        }
        return book;
    }

    public void createBook(Book book){
        this.bookRepository.save(book);
    }
}
