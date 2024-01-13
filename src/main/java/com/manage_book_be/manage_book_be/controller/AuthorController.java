package com.manage_book_be.manage_book_be.controller;

import com.manage_book_be.manage_book_be.entity.AuthorEntity;
import com.manage_book_be.manage_book_be.entity.BookEntity;
import com.manage_book_be.manage_book_be.response.AuthorDTO;
import com.manage_book_be.manage_book_be.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/create-author")
    public String create_author(@RequestBody AuthorEntity authorEntity) {
        return  authorService.createAuthor(authorEntity);
    }

    @GetMapping("/get-author/{authID}")
    public Optional<AuthorEntity> author (@PathVariable("authID") int authID) {
        Optional<AuthorEntity> auth = authorService.getAuthorById(authID);
        return  auth;
    }

    @GetMapping("/{authorId}/books")
    public List<BookEntity> getBooksByAuthorId(@PathVariable int authorId) {
        return authorService.getBooksByAuthorId(authorId);
    }

    @GetMapping("/get-all-authors")
    public List<AuthorDTO> getAuthors() {
        return authorService.getAllAuthor();
    }

}
