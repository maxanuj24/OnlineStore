package com.startup.OnlineStore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
@Embeddable
public class MerchantLocation {

        private int merchant_id;
        private int location_id;
        private String merchant_location_name;

        private String merchant_location_type;

        private String merchant_flat;
        private String merchant_city;
        private int merchant_pin;
        private String merchant_contact;

    public MerchantLocation() {
    }

    public MerchantLocation(int merchant_id, int location_id, String merchant_location_name, String merchant_location_type, String merchant_flat, String merchant_city, int merchant_pin, String merchant_contact) {
        this.merchant_id = merchant_id;
        this.location_id = location_id;
        this.merchant_location_name = merchant_location_name;
        this.merchant_location_type = merchant_location_type;
        this.merchant_flat = merchant_flat;
        this.merchant_city = merchant_city;
        this.merchant_pin = merchant_pin;
        this.merchant_contact = merchant_contact;
    }

    public int getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(int merchant_id) {
        this.merchant_id = merchant_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getMerchant_location_name() {
        return merchant_location_name;
    }

    public void setMerchant_location_name(String merchant_location_name) {
        this.merchant_location_name = merchant_location_name;
    }

    public String getMerchant_location_type() {
        return merchant_location_type;
    }

    public void setMerchant_location_type(String merchant_location_type) {
        this.merchant_location_type = merchant_location_type;
    }

    public String getMerchant_flat() {
        return merchant_flat;
    }

    public void setMerchant_flat(String merchant_flat) {
        this.merchant_flat = merchant_flat;
    }

    public String getMerchant_city() {
        return merchant_city;
    }

    public void setMerchant_city(String merchant_city) {
        this.merchant_city = merchant_city;
    }

    public int getMerchant_pin() {
        return merchant_pin;
    }

    public void setMerchant_pin(int merchant_pin) {
        this.merchant_pin = merchant_pin;
    }

    public String getMerchant_contact() {
        return merchant_contact;
    }

    public void setMerchant_contact(String merchant_contact) {
        this.merchant_contact = merchant_contact;
    }

    @Override
    public String toString() {
        return "MerchantLocation{" +
                "merchant_id=" + merchant_id +
                ", location_id=" + location_id +
                ", merchant_location_name='" + merchant_location_name + '\'' +
                ", merchant_location_type='" + merchant_location_type + '\'' +
                ", merchant_flat='" + merchant_flat + '\'' +
                ", merchant_city='" + merchant_city + '\'' +
                ", merchant_pin=" + merchant_pin +
                ", merchant_contact='" + merchant_contact + '\'' +
                '}';
    }
}

