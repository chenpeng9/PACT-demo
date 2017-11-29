package com.peng.controller;

import com.peng.model.Book;
import com.peng.model.Books;
import com.peng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private
    BookService bookService;

    @RequestMapping("/books/v1/volumes")
    public Books Books() {
        return bookService.getBook();
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

}
