//package com.mobile.demo.entity;
//
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long userid;
//
//    private String username;
//    private String password;
//    private String email;
//    private String phoneNumber;
//    private String address;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference(value = "user-orders")
//    private List<Order> orders;
//
//    // Getters and Setters
//    public Long getUserid() {
//        return userid;
//    }
//
//    public void setUserid(Long userid) {
//        this.userid = userid;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
//
//	public User(Long userid, String username, String password, String email, String phoneNumber, String address,
//			List<Order> orders) {
//		super();
//		this.userid = userid;
//		this.username = username;
//		this.password = password;
//		this.email = email;
//		this.phoneNumber = phoneNumber;
//		this.address = address;
//		this.orders = orders;
//	}
//
//	
//    
//    
//}

package com.mobile.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-orders")
    private List<Order> orders;

    
    public User() {
		super();
	}

	// Getters and Setters
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public User(Long userid, String username, String password, String email, String phoneNumber, String address) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public User(Long userid, String username, String password, String email, String phoneNumber, String address,
                List<Order> orders) {
        this(userid, username, password, email, phoneNumber, address);
        this.orders = orders;
    }
}
