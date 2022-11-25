package com.productcatalogue.productdemo.service;

import com.productcatalogue.productdemo.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    List<Product> getProduct();
    Product getProductById(long productid);
    void deleteProduct(long productid);

}
