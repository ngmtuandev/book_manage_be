package com.manage_book_be.manage_book_be.service;

import com.manage_book_be.manage_book_be.Request.BookRequest;
import com.manage_book_be.manage_book_be.entity.BookEntity;
import com.manage_book_be.manage_book_be.repostory.BookDTO;

import java.util.List;

public interface BookService {
    String save_book(BookEntity book);
    List<BookEntity> listBook();

    BookEntity getItemBook(String book);

    BookEntity editBook(String name, BookRequest bookRequest);

    List<BookDTO> getAllBooksWithAuthorInfo();

}
