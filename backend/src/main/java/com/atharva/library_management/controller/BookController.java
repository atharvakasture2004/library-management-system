package com.atharva.library_management.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atharva.library_management.constant.ApiConstants;
import com.atharva.library_management.dto.BookResponse;
import com.atharva.library_management.dto.CreateBookRequest;
import com.atharva.library_management.service.BookService;

@RestController
@RequestMapping(ApiConstants.BOOK_API)
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookResponse createBook(@RequestBody CreateBookRequest request){
        return bookService.createBook(request);
    }

}
