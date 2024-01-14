package com.manage_book_be.manage_book_be.service;

import com.manage_book_be.manage_book_be.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity saveProduct(ProductEntity product);
    List<ProductEntity> listProducts();

    ProductEntity getItemProduct(Integer id);

    String deletrproduct(Integer id);

}
