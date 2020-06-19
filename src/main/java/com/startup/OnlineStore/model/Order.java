package com.startup.OnlineStore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.startup.OnlineStore.Enum.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue
    private int id;
    private int uid; //userId


    private int m_id; //merchantId
    private int addrid; //addressId


    private OrderStatus orderStatus;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonBackReference
    User user;

    @Column
    @ManyToMany(cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<Item>();
    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
    public int getAddrid() {
        return addrid;
    }

    public void setAddrid(int addrid) {
        this.addrid = addrid;
    }

    public Order() {
    }

    public Order(int uid, int m_id,OrderStatus orderStatus,int addrid) {
        this.uid = uid;
        this.orderStatus = orderStatus;
        this.addrid = addrid;
        this.m_id = m_id;
    }
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", mid=" + m_id +
                ", uid=" + uid +
                ", status='" + orderStatus + '\'' +
                ", user=" + user +
                '}';
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
