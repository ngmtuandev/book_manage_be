package com.manage_book_be.manage_book_be.service;

import com.manage_book_be.manage_book_be.entity.AuthorEntity;
import com.manage_book_be.manage_book_be.entity.BookEntity;
import com.manage_book_be.manage_book_be.repostory.AuthorRepositories;
import com.manage_book_be.manage_book_be.repostory.BookRepositories;
import com.manage_book_be.manage_book_be.response.AuthorDTO;
import com.manage_book_be.manage_book_be.response.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorServiceInpl implements AuthorService {
    @Autowired
    AuthorRepositories authorRepositories;

    @Autowired
    BookRepositories bookRepositories;
    @Override
    public AuthorEntity getAuthorInfo(String nameAuthor) {
        return authorRepositories.findByNameAuthor(nameAuthor);
    }

    @Override
    public Optional<AuthorEntity> getAuthorById(int authorId) {
        return authorRepositories.findById(authorId);
    }

    public String createAuthor(AuthorEntity authorEntity) {
        AuthorEntity author_new = authorRepositories.save(authorEntity);
        return "success";
    }

    @Override
    public List<BookEntity> getBooksByAuthorId(int authorID) {
        return bookRepositories.findByAuthorId(authorID);
    }

    @Override
    public List<AuthorDTO> getAllAuthor() {
        List<AuthorEntity> auths = authorRepositories.findAll();
        List<AuthorDTO> authDTOS = new ArrayList<>();
        for (AuthorEntity author : auths) {
            AuthorDTO auth = new AuthorDTO();
            auth.setAddress(author.getAddress());
            auth.setNameAuthor(author.getNameAuthor());

            Set<BookEntity> booksOfAuth = author.getBooks();
            List<BookDTO> listBooks = new ArrayList<>();

            for (BookEntity book : booksOfAuth) {
                BookDTO book_dto = new BookDTO();
                book_dto.setNameBook(book.getName());
                book_dto.setPriceBook(book.getPrice());

                listBooks.add(book_dto);

            }

            auth.setBookDTO(listBooks);
            authDTOS.add(auth);

        }

        return authDTOS;

    }
}
