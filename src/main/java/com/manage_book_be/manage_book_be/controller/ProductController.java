package com.manage_book_be.manage_book_be.controller;

import com.manage_book_be.manage_book_be.entity.ProductEntity;
import com.manage_book_be.manage_book_be.repostory.ProductReposotories;
import com.manage_book_be.manage_book_be.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ProductReposotories productReposotories;

    @PostMapping("/save-product")
    ResponseEntity<?> saveProduct(@RequestBody ProductEntity product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/")
    ResponseEntity<?> getProductAll() {
        return new ResponseEntity<>(productService.listProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getItemProduct(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.deletrproduct(id), HttpStatus.OK);
    }

    @PutMapping("/editProduct/{id}")
    ResponseEntity<?> updatedProduct(@PathVariable Integer id, @RequestBody ProductEntity product) {
        ProductEntity findProductEdit = productReposotories.findById(id).get();

        if (findProductEdit != null) {
            findProductEdit.setProductName(product.getProductName());
            findProductEdit.setDescription(product.getDescription());
            findProductEdit.setPrice(product.getPrice());
            findProductEdit.setStatus(product.getStatus());
        }

        productReposotories.save(findProductEdit);

        return new ResponseEntity<>("UPDATED SUCCESSFULLY", HttpStatus.OK);

    }

}
