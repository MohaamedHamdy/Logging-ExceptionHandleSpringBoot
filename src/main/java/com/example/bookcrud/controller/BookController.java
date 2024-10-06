package com.example.bookcrud.controller;

import java.util.List;
import java.util.Optional;

import com.example.bookcrud.Book;
import com.example.bookcrud.BookService;
import com.example.bookcrud.exception.BookNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        logger.trace("TRACE MESSAGE");
        logger.warn("WARNING MESSAGE");
        logger.debug("DEBUG MESSAGE");
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
//        try {
//            logger.info("INFO MESSAGE");
//            return bookService.getBookById(id);
//        }catch (Exception e) {
//            logger.error("ERROR MESSAGE{}", e.getMessage());
//            throw new BookNotFoundException(id);
//        }
        return bookService.getBookById(id).orElseThrow(() -> {
            logger.error("ERROR MESSAGE");
            return new BookNotFoundException(id);
        });
//        throw new IllegalStateException("fnkls");

    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBookById(id);
    }

    @PutMapping("/{id}")
    public Optional<Book> updateBook(@RequestBody Book book, @PathVariable long id) {
        return bookService.updateBook(id, book);
    }
}
