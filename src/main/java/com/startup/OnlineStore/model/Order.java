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
    private int uid;
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    User user;

    /* @OneToMany
    private List<Item> items = new ArrayList<>();
    */
   /* @OneToOne
    private Address address;
    */
    public Order() {
    }

    public Order(int uid, String status) {
        this.uid = uid;
        this.status = status;
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
                //  ", items=" + items +
                //  ", address=" + address +
                ", user=" + user +
                '}';
    }

}
