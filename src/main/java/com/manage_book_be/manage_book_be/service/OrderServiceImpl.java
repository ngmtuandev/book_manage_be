package com.manage_book_be.manage_book_be.service;

import com.manage_book_be.manage_book_be.entity.BookEntity;
import com.manage_book_be.manage_book_be.entity.OrderEntity;
import com.manage_book_be.manage_book_be.repostory.BookRepositories;
import com.manage_book_be.manage_book_be.repostory.OrderRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepositories orderRepositories;

    @Autowired
    BookRepositories bookRepositories;

    @Override
    public OrderEntity create_order(OrderEntity order) {
        System.out.println("order " + order.getBooksOrder());
        List<BookEntity> listBookOrder = new ArrayList<>();
        for (BookEntity book : order.getBooksOrder()) {
            List<BookEntity> book_item = bookRepositories.findByName(book.getName());
            listBookOrder.add(book_item.get(0));
            System.out.println("book item : >>>>>>>>>" + book_item);
        }
        order.setBooksOrder(listBookOrder);
        return orderRepositories.save(order);
    }

    @Override
    public Optional<OrderEntity> get_order(int orderID) {
        Optional<OrderEntity> order_item = orderRepositories.findById(orderID);
        System.out.println("order_item >>>>>" + order_item.get());
        return order_item;
    }
}
