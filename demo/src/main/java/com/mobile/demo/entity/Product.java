package com.mobile.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;
//
//@Entity
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long productid;
//
//    private String productName;
//    private String brand;
//    private String model;
//    private double price;
//    private String description;
//    private int stockQuantity;
//
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private List<OrderDetail> orderDetails;
//
//    // Getters and Setters
//    public Long getProductid() {
//        return productid;
//    }
//
//    public void setProductid(Long productid) {
//        this.productid = productid;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getStockQuantity() {
//        return stockQuantity;
//    }
//
//    public void setStockQuantity(int stockQuantity) {
//        this.stockQuantity = stockQuantity;
//    }
//
//    public List<OrderDetail> getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(List<OrderDetail> orderDetails) {
//        this.orderDetails = orderDetails;
//    }
//}




@Entity
public class Product {
    
    @Id
    private Long productid;
    private String brand;
    private String model;
    private String description;
    private double price;
    private int stockQuantity;
    private String productName;

    // Constructor
    public Product(Long productid, String brand, String model, String description, double price, int stockQuantity, String productName) {
        this.productid = productid;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.productName = productName;
    }
    
    

    public Product() {
		super();
	}



	// Getters and Setters
    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}



//package com.mobile.demo.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long productid;
//
//    private String productName;
//    private String brand;
//    private String model;
//    private double price;
//    private String description;
//    private int stockQuantity;
//
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private List<OrderDetail> orderDetails;
//
//    // Default constructor
//    public Product() {}
//
//    // Constructor for testing
//    public Product(Long productid, String productName, String brand, String model, double price, String description, int stockQuantity) {
//        this.productid = productid;
//        this.productName = productName;
//        this.brand = brand;
//        this.model = model;
//        this.price = price;
//        this.description = description;
//        this.stockQuantity = stockQuantity;
//        
//    }
//
//    // Getters and Setters
//    public Long getProductid() {
//        return productid;
//    }
//
//    public void setProductid(Long productid) {
//        this.productid = productid;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getStockQuantity() {
//        return stockQuantity;
//    }
//
//    public void setStockQuantity(int stockQuantity) {
//        this.stockQuantity = stockQuantity;
//    }
//
//    public List<OrderDetail> getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(List<OrderDetail> orderDetails) {
//        this.orderDetails = orderDetails;
//    }
//}
