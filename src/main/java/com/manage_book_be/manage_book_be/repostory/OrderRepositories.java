package com.manage_book_be.manage_book_be.repostory;

import com.manage_book_be.manage_book_be.entity.OrderEntity;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositories extends JpaRepository<OrderEntity, Integer> {
}
