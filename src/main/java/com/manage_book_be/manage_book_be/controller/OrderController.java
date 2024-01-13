package com.manage_book_be.manage_book_be.controller;

import com.manage_book_be.manage_book_be.entity.OrderEntity;
import com.manage_book_be.manage_book_be.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @PostMapping("/create-order")
    public String create_order(@RequestBody OrderEntity order) {
        OrderEntity newOrder = orderService.create_order(order);
        if (newOrder != null) return "create-order successfully";
        else return "fail";
    }

    @GetMapping("/get-order/{orderID}")
    public OrderEntity get_order(@PathVariable int orderID) {
        Optional<OrderEntity> listOrders = orderService.get_order(orderID);
        if (listOrders != null) {
            return  listOrders.get();
        }
        return  null;
    }
}
