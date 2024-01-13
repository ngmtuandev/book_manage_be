package com.manage_book_be.manage_book_be.service;

import com.manage_book_be.manage_book_be.entity.OrderEntity;

import java.util.Optional;

public interface OrderService {
    OrderEntity create_order(OrderEntity order);
    Optional<OrderEntity> get_order(int orderID);
}
