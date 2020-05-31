package com.startup.OnlineStore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String type;

    private String flat;
    private String city;
    private int pin;
    private String contact;
    private int uid; //userId

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonBackReference
    User user;


    public Address() {
    }
    public Address(String name, String type, String flat, String city, int pin, String contact, int uid) {
        this.name = name;
        this.type = type;
        this.flat = flat;
        this.city = city;
        this.pin = pin;
        this.contact = contact;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

   /* @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", flat='" + flat + '\'' +
                ", city='" + city + '\'' +
                ", pin=" + pin +
                ", contact='" + contact + '\'' +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }*/

}
