package edu.unict.magazon.Models;

import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class MagazonUsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column(name = "user_name")
    private String userName;
    private String user_surname;
    private String number;
    @Column(name="email", unique = true)
    private String email;
    private String address;
    private String password;
    private LocalDate registration_date;
    @Enumerated(EnumType.STRING) 
    @Column(nullable=false)
    private Role role=Role.USER;

    public enum Role {
        ADMIN,
        USER
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @PrePersist
    protected void onCreate() {
        this.registration_date = LocalDate.now();
    }
}
