package com.startup.OnlineStore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String phone;

    private String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)//
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }


 /*   public Cart getCart() {
        return cart;
    }*/

    /*  public List<Address> getAddress() {
          return addresses;
      }*/



   /* @OneToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @OneToMany
    private List<Address> addresses = new ArrayList<>();
*/


   /* public void addAddress(Address address){
        addresses.add(address);
    }*/
/*
    public void setCart(Cart cart) {
        this.cart = cart;
    }*/
}
