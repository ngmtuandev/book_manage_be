package com.manage_book_be.manage_book_be.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "_customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String gender;


    // one - to - many : 1 khach hang - nhieu don hang
    @OneToMany(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "prd_fk", referencedColumnName = "id")
    private List<ProductEntity> products;


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

    public CustomerEntity(String name, String email, String gender, List<ProductEntity> products) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.products = products;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public CustomerEntity() {
    }

    public CustomerEntity(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public CustomerEntity(int id, String name, String email, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
