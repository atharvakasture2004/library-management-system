package com.atharva.library_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atharva.library_management.dto.BookResponse;
import com.atharva.library_management.dto.CreateBookRequest;
import com.atharva.library_management.model.Book;
import com.atharva.library_management.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse createBook(CreateBookRequest request) {
        Book book = new Book(
                request.getTitle(),
                request.getAuthor(),
                request.getIsbn(),
                request.getTotalCopies(),
                request.getAvailableCopies());

        Book savedBook = bookRepository.save(book);

        return new BookResponse(
                savedBook.getId(),
                savedBook.getTitle(),
                savedBook.getAuthor(),
                savedBook.getIsbn(),
                savedBook.getTotalCopies(),
                savedBook.getAvailableCopies());
    }

    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream().map(book -> new BookResponse(book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getTotalCopies(),
                book.getAvailableCopies())).toList();
    }

}
