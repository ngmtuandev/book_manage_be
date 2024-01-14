package com.manage_book_be.manage_book_be.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "_product")
public class ProductEntity {

    /*

book_manage_v1=# select * from _product;
 id | description  | price | product_name |    status    | prd_fk
----+--------------+-------+--------------+--------------+--------
  1 | 222222222222 |  10.1 | 222222222222 | 222222222222 |
 52 | aaaaaa       |  12.3 | aaaaa        | avaible      |      1
 53 | vvvv         |  12.3 | vvvv         | vvv          |      1
 54 | aaaaaa       |  12.3 | aaaaa        | avaible      |      2
 55 | vvvv         |  12.3 | vvvv         | vvv          |      2

    */


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "productName")
    private String productName;
    private String description;
    private double price;
    private String status;

    public ProductEntity() {
    }

    public ProductEntity(Integer id, String productName, String description, double price, String status) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public ProductEntity(String productName, String description, double price, String status) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
