package com.finalmas.app.model.complexFields;

import com.finalmas.app.model.Person;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "ContantData")
public class ContantData {
    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Basic
    private String phoneNumber;
    @Basic
    private String city;
    @Basic
    private String street;
    @Basic
    private String houseNumber;
    @Basic
    private String postCode;

    @OneToOne
    private Person person;

    public ContantData(String phoneNumber, String city, String street, String houseNumber, String postCode) {
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ContantData() {}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
