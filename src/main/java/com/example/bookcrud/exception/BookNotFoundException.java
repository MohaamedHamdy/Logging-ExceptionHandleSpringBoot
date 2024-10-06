package com.example.bookcrud.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(long id) {
        super("Book not found with id " + id);
    }
}
