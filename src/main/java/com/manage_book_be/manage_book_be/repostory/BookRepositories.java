package com.manage_book_be.manage_book_be.repostory;

import com.manage_book_be.manage_book_be.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositories extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByName(String name);

//    BookEntity findByName(String name);
    List<BookEntity> findByAuthorId(int authorID);
}
