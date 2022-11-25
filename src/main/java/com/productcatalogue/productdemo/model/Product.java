package com.productcatalogue.productdemo.model;

import javax.persistence.*;

@Entity
@Table(name="Product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productid;

    @Column(name="productname")
    private String productname;

    @Column(name="quantity")
    private int quantity;

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
