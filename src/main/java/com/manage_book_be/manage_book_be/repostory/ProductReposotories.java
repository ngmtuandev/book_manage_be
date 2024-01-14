package com.manage_book_be.manage_book_be.repostory;

import com.manage_book_be.manage_book_be.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReposotories extends JpaRepository<ProductEntity, Integer> {
}
