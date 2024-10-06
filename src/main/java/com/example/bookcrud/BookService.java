package com.example.bookcrud;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(BookService.class);

    // create book
    public Book createBook(Book book) {
//        logger.info("Creating new book");
        return bookRepository.save(book);
    }

    // get list of books
    public List<Book> getAllBooks() {
//        logger.info("Getting all books");
        return bookRepository.findAll();
    }

    // get book by id
    public Optional<Book> getBookById(long id) {
        return bookRepository.findById(id);
    }

    // delete book by id
    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }

    // update book
    public Optional<Book> updateBook(long id, Book updatedBook) {
        return bookRepository.findById(id).map(
                book -> {
                    book.setAuthor(updatedBook.getAuthor());
                    book.setTitle(updatedBook.getTitle());
                    book.setPrice(updatedBook.getPrice());
                    book.setPages(updatedBook.getPages());
                    return bookRepository.save(book);
                }
        );
    }
}
