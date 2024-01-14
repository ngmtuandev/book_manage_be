package com.manage_book_be.manage_book_be.repostory;

import com.manage_book_be.manage_book_be.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositories extends JpaRepository<ProductEntity, Integer> {
}
