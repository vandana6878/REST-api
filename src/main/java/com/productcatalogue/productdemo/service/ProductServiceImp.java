package com.productcatalogue.productdemo.service;

import com.productcatalogue.productdemo.Exception.ProductException;
import com.productcatalogue.productdemo.model.Product;
import com.productcatalogue.productdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.ProtocolException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> prodobj = this.productRepository.findById(product.getProductid());
        if(prodobj.isPresent()){
            Product prodUpdate = prodobj.get();
            prodUpdate.setProductid(product.getProductid());
            prodUpdate.setProductname(product.getProductname());
            prodUpdate.setQuantity(product.getQuantity());
            return this.productRepository.save(prodUpdate);
        }else{
            throw new ProductException("Product not found with ID:" +product.getProductid());
        }

    }

    @Override
    public List<Product> getProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(long prodId) {
        Optional<Product> prodobj = this.productRepository.findById(prodId);
        if(prodobj.isPresent()){
            return prodobj.get();
        }else{
            throw new ProductException("Product not found with ID:" +prodId);
        }

    }

    @Override
    public void deleteProduct(long prodId) {
        Optional<Product> prodobj = this.productRepository.findById(prodId);
        if(prodobj.isPresent()){
            this.productRepository.deleteById(prodId);
        }
        else{
            throw new ProductException("Product does'nt exist with ID:" +prodId);
        }

    }
}