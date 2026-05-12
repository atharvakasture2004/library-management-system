package com.atharva.library_management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atharva.library_management.constant.ApiConstants;
import com.atharva.library_management.service.BookService;

@RestController
@RequestMapping(ApiConstants.API_BASE)
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

}
