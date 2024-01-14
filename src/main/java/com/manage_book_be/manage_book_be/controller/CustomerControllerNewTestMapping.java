package com.manage_book_be.manage_book_be.controller;

import com.manage_book_be.manage_book_be.Request.OrderRequestDTO;
import com.manage_book_be.manage_book_be.entity.CustomerEntity;
import com.manage_book_be.manage_book_be.repostory.CustomerRepositories;
import com.manage_book_be.manage_book_be.repostory.ProductReposotories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerControllerNewTestMapping {

    @Autowired
    ProductReposotories productReposotories;

    @Autowired
    CustomerRepositories customerRepositories;

    @PostMapping("/v2/create-order")
    CustomerEntity createOrder(@RequestBody OrderRequestDTO order) {
        return customerRepositories.save(order.getCustomer());
    }

    /*
    {
    "customer" : {
        "name": "tuan",
    "email": "manhtuan",
    "gender": "123",
    "products": [
        {
            "productName": "aaaaa",
            "description": "aaaaaa",
            "price": 12.3,
            "status": "avaible"
        },
        {
            "productName": "vvvv",
            "description": "vvvv",
            "price": 12.3,
            "status": "vvv"
        }
    ]
    }
}


book_manage_v1=# select * from _product;
 id | description  | price | product_name |    status    | prd_fk
----+--------------+-------+--------------+--------------+--------
  1 | 222222222222 |  10.1 | 222222222222 | 222222222222 |
 52 | aaaaaa       |  12.3 | aaaaa        | avaible      |      1
 53 | vvvv         |  12.3 | vvvv         | vvv          |      1
(3 rows)


    */




    @GetMapping("/v2/all-order")
    List<CustomerEntity> findAllOrderV2() {
        return customerRepositories.findAll();
    }


}
