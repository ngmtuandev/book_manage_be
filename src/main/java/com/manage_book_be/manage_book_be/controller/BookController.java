package com.manage_book_be.manage_book_be.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manage_book_be.manage_book_be.Request.BookRequest;
import com.manage_book_be.manage_book_be.entity.BookEntity;
import com.manage_book_be.manage_book_be.repostory.BookDTO;
import com.manage_book_be.manage_book_be.response.ResponseModel;
import com.manage_book_be.manage_book_be.service.BookService;
import com.manage_book_be.manage_book_be.service.BookServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @GetMapping("/book")
    public String getBooks() {
        return "get list book";
    }

    @JsonIgnore
    @PostMapping("/save_book")
    public String save_book (@RequestBody BookEntity book) {
        System.out.println("request save boook" + book.toString());
        String result = bookServiceImpl.save_book(book);
        return result;
    }

    @GetMapping("/get-all")
    @Transactional
    public List<BookDTO> getAllBooks () {
        List<BookDTO> books = bookServiceImpl.getAllBooksWithAuthorInfo();
        System.out.println("Number of books: " + books.size());
        return books;
    }

    @GetMapping("/get-item/{name}")
    public BookEntity getItem (@PathVariable("name") String name) {
        System.out.println("name " + name);
        BookEntity item = bookServiceImpl.getItemBook(name);
        System.out.println("item + " + item.getAuthor());
        return item;
    }

    @PutMapping("/edit/{name}")
    public BookEntity editBook (@PathVariable("name") String name, @RequestBody BookRequest bookRequest) {
        BookEntity new_book_edit = bookServiceImpl.editBook(name, bookRequest);
        return new_book_edit;


    }

}
