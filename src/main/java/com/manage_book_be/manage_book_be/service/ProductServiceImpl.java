package com.manage_book_be.manage_book_be.service;

import com.manage_book_be.manage_book_be.entity.ProductEntity;
import com.manage_book_be.manage_book_be.repostory.ProductReposotories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductReposotories productReposotories;

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        return productReposotories.save(product);
    }

    @Override
    public List<ProductEntity> listProducts() {
        return productReposotories.findAll();
    }

    @Override
    public ProductEntity getItemProduct(Integer id) {
        return productReposotories.findById(id).get();
    }

    @Override
    public String deletrproduct(Integer id) {
        ProductEntity findProduct = productReposotories.findById(id).get();
        if (findProduct != null) {
            productReposotories.delete(findProduct);
            return "Delete product successfully";
        }
        return "ddetele failure";
    }
}
