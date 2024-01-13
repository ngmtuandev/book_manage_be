package com.manage_book_be.manage_book_be.service;

import com.manage_book_be.manage_book_be.entity.AuthorEntity;
import com.manage_book_be.manage_book_be.entity.BookEntity;
import com.manage_book_be.manage_book_be.response.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorEntity getAuthorInfo(String nameAuthor);
    Optional<AuthorEntity> getAuthorById(int authorID);

//    Optional<AuthorEntity> getAuthorById(AuthorEntity author);

    String createAuthor(AuthorEntity authorEntity);
    List<BookEntity> getBooksByAuthorId(int authorID);

    List<AuthorDTO> getAllAuthor();

}
