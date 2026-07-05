package com.library.controller;

import com.library.entity.Book;
import com.library.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Create Book
    @PostMapping
    public Book addBook(@RequestBody Book book) {

        return bookRepository.save(book);

    }

    // Get All Books
    @GetMapping
    public List<Book> getAllBooks() {

        return bookRepository.findAll();

    }

    // Get Book By Id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {

        Optional<Book> book = bookRepository.findById(id);

        return book.orElse(null);

    }

    // Update Book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book updatedBook) {

        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {

            Book book = optionalBook.get();

            book.setTitle(updatedBook.getTitle());

            book.setAuthor(updatedBook.getAuthor());

            book.setPrice(updatedBook.getPrice());

            return bookRepository.save(book);

        }

        return null;

    }

    // Delete Book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        bookRepository.deleteById(id);

        return "Book Deleted Successfully.";

    }

}