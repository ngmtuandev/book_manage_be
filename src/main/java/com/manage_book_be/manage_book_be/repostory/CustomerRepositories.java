package com.manage_book_be.manage_book_be.repostory;

import com.manage_book_be.manage_book_be.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositories extends JpaRepository<CustomerEntity, Integer> {
}
