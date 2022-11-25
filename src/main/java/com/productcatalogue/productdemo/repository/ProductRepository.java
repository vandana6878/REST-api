package com.productcatalogue.productdemo.repository;

import com.productcatalogue.productdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
