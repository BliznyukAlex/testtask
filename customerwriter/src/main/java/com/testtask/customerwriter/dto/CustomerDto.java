package com.testtask.customerwriter.dto;


import com.testtask.customerwriter.entity.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class CustomerDto {

    String firstName;

    String lastName;

    LocalDateTime created;

    public CustomerDto(){

    }

    public CustomerDto(String firstName, String lastName, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = created;
    }

    public CustomerDto(Customer customer){
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.created = customer.getCreated();
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

    @Override
    public String toString() {
        return "CustomerDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", created=" + created +
                '}';
    }
}
