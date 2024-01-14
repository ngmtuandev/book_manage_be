package com.manage_book_be.manage_book_be.Request;

import com.manage_book_be.manage_book_be.entity.CustomerEntity;

public class OrderRequestDTO {

    private CustomerEntity customer;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(CustomerEntity customer) {
        this.customer = customer;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
