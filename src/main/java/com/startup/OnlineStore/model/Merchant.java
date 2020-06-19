package com.startup.OnlineStore.model;
import javax.persistence.*;

@Entity
public class Merchant {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable=false)
    private String name;
    @Embedded
    private MerchantLocation address;
    private String phone;
    private String email;
    private Boolean deliveryFacility;

    public Merchant() {
    }

    public Merchant(String name, MerchantLocation address, String phone, String email, Boolean deliveryFacility) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.deliveryFacility = deliveryFacility;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", deliveryFacility=" + deliveryFacility +
                '}';
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

    public MerchantLocation getAddress() {
        return address;
    }

    public void setAddress(MerchantLocation address) {
        this.address = address;
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

    public Boolean getDeliveryFacility() {
        return deliveryFacility;
    }

    public void setDeliveryFacility(Boolean deliveryFacility) {
        this.deliveryFacility = deliveryFacility;
    }

}
