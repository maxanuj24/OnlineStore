package com.startup.OnlineStore.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Login {
    @Id
    @Email(message = "Email should be valid")
    @NotNull(message = "User Name cannot be null")
    String username;
    @NotNull
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
    String password;

    @NotNull
    String phone;

    int uid;
    int m_id;
    @Embedded
    DateUtil dateUtil;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public Login() {
    }

    public Login(@Email(message = "Email should be valid") @NotNull(message = "User Name cannot be null") String username, @NotNull @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters") String password) {
        this.username = username;
        this.password = password;
    }
}
