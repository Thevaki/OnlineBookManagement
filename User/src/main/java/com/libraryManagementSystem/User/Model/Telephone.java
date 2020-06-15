package com.libraryManagementSystem.User.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Telephone{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min=10,max = 10,message = "Enter valid telephone number")
    @NotBlank(message = "Telephone number cannot be empty")
    private String telephoneNumber_1;

    @Size(min=10,max = 10,message = "Enter valid telephone number")
    private String telephoneNumber_2;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelephoneNumber_1() {
        return telephoneNumber_1;
    }

    public void setTelephoneNumber_1(String telephoneNumber_1) {
        this.telephoneNumber_1 = telephoneNumber_1;
    }

    public String getTelephoneNumber_2() {
        return telephoneNumber_2;
    }

    public void setTelephoneNumber_2(String telephoneNumber_2) {
        this.telephoneNumber_2 = telephoneNumber_2;
    }

}
