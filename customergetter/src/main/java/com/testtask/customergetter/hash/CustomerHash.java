package com.testtask.customergetter.hash;

import com.testtask.customergetter.entity.Customer;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.Objects;

@RedisHash("CustomerHash")
public class CustomerHash {

    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDateTime created;

    public CustomerHash(){}

    public CustomerHash(Integer id, String firstName, String lastName, LocalDateTime created) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = created;
    }

    public CustomerHash(Customer customer){
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.created = customer.getCreated();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerHash that = (CustomerHash) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, created);
    }

    @Override
    public String toString() {
        return "CustomerHash{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", created=" + created +
                '}';
    }
}
