package com.startup.OnlineStore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private int addrid; //addressId
    private String status;

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

    public Order(int uid, String status,int addrid) {
        this.uid = uid;
        this.status = status;
        this.addrid = addrid;
    }
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid=" + uid +
                ", status='" + status + '\'' +
                ", user=" + user +
                '}';
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
