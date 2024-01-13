package com.manage_book_be.manage_book_be.repostory;

import com.manage_book_be.manage_book_be.Request.AuthorRequest;
import com.manage_book_be.manage_book_be.entity.AuthorEntity;
import com.manage_book_be.manage_book_be.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthorRepositories extends JpaRepository<AuthorEntity, Integer> {

    AuthorEntity findByNameAuthor(String nameAuthor);

}
