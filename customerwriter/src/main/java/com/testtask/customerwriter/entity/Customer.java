package com.testtask.customerwriter.entity;

import com.testtask.customerwriter.dto.CustomerDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "created")
    LocalDateTime created;

    public Customer() {
    }

    public Customer(Integer id, String firstName, String lastName, LocalDateTime created) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = created;
    }

    public Customer(CustomerDto customerDto){
        this.firstName = customerDto.getFirstName();
        this.lastName = customerDto.getLastName();
        this.created = customerDto.getCreated();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
