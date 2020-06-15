package com.libraryManagementSystem.User.Model;

import lombok.Data;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class AppUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(unique = true,updatable = false)
    @NotBlank(message = "Username cannot be empty") //it's not null and the trimmed length is greater than zero
    private String username;

    @NotNull(message = "Password cannot be empty")
    private String password;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Enter valid email address")
    private  String email;

    @NotBlank(message = "Role cannot be empty")
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    @OneToOne(cascade = CascadeType.ALL)
    Telephone telephones;

    public Telephone getTelephones() {
        return telephones;
    }

    public void setTelephones(Telephone telephones) {
        this.telephones = telephones;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Address getAddress() {
        return address;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
