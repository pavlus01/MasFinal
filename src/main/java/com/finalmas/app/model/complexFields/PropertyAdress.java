package com.finalmas.app.model.complexFields;

import com.finalmas.app.model.PropertyInsurance;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "PropertyAdress")
public class PropertyAdress {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Basic
    private String city;
    @Basic
    private String street;
    @Basic
    private String houseNumber;
    @Basic
    private String postCode;

    @OneToOne
    private PropertyInsurance propertyInsurance;

    public PropertyInsurance getPropertyInsurance() {
        return propertyInsurance;
    }

    public void setPropertyInsurance(PropertyInsurance propertyInsurance) {
        this.propertyInsurance = propertyInsurance;
    }

    public PropertyAdress( String city, String street, String houseNumber, String postCode) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
    }

    public PropertyAdress() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
}
