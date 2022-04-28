package com.qa.baeprojectone.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id // This makews the column a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This makes the column auto-increment
    private long id;

    // Creates a column called "first_name"
    // This column CAN NOT be null
    @Column(name = "firstname", nullable = false)
    private String firstName;

    // Creates a column called "last_name"
    // This colun CAN NOT be null
    @Column(nullable = false)
    private String lastName;

    // Creates a column called "username"
    @Column(unique = true)
    private String username;

    // Creates a column called "phone_number"
    @Column(unique = true)
    private String phoneNumber;

    // Creates a column called "last_name"
    // This colun CAN NOT be null
    @Column(nullable = false)
    private String address;

    // Default Constructor
    public User() {
    }

    public User(String firstName, String lastName, String username, String phoneNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber = phoneNumber;
        // this.address= address;
    }

    public User(long id, String firstName, String lastName, String username, String phoneNumber) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Used for reading/selecting /(and testing)

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
                + ",phoneNumber=" + phoneNumber +
                ", getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
                + ", getUsername()=" + getUsername() + "getPhoneNumber()=" + getPhoneNumber() +
                ",getAddress()=" + getAddress() +
                ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

    public void setId(long id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, id, lastName, username, phoneNumber, address);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
                && Objects.equals(username, other.username)
                && Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(address, other.address);
    }

}

