package com.startup.OnlineStore.model;

import com.startup.OnlineStore.Enum.Category;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Float price;
    private int quantity;
    private Category categoryname;
    private int m_id;

    //private String description;
    //private String company;
    //private Image image;
    //private int availableQuantity;
    //private int quantitySelected;

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", categoryname='" + categoryname + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public Category getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(Category categoryname) {
        this.categoryname = categoryname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Item(Category categoryname, String name, Float price, int quantity, int m_id) {
        this.categoryname = categoryname;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.m_id = m_id;
    }
}
