package com.productcatalogue.productdemo.controller;

import com.productcatalogue.productdemo.model.Product;
import com.productcatalogue.productdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productservice;

    @GetMapping("/product")
    private ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(this.productservice.getProduct());
    }

    @GetMapping("/product/{productid}")
    private Product getProductById(@PathVariable long productid) {
        return this.productservice.getProductById(productid);
    }

    @PostMapping("/products")
    private ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(this.productservice.createProduct(product));
    }

    @PutMapping("/product/{productid}")
    private ResponseEntity<Product> updateProduct(@PathVariable long productid,@RequestBody Product product) {
        product.setProductid(productid);
        return ResponseEntity.ok().body(this.productservice.updateProduct(product));
    }

    @DeleteMapping("/product/{productid}")
    private HttpStatus deleteProduct(@PathVariable long productid) {
        this.productservice.deleteProduct(productid);
        return HttpStatus.OK;
    }


}
