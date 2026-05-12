package com.atharva.library_management.service;

import org.springframework.stereotype.Service;

import com.atharva.library_management.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
