package com.finalmas.app.model;

import com.finalmas.app.model.complexFields.PropertyAdress;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity(name = "PropertyInsurance")
public class PropertyInsurance extends Policy{
    public PropertyInsurance(String name, String description, LocalDate creationDate, LocalDate usefullnessDate, double sumInsured, double apartamentSize, PropertyAdress propertyAdress) {
        super(name, description, creationDate, usefullnessDate, sumInsured);
        this.apartamentSize = apartamentSize;
        this.propertyAdress = propertyAdress;
        propertyAdress.setPropertyInsurance(this);
    }

    public PropertyInsurance(double apartamentSize, PropertyAdress propertyAdress) {
        this.apartamentSize = apartamentSize;
        this.propertyAdress = propertyAdress;
        propertyAdress.setPropertyInsurance(this);
    }
    public PropertyInsurance(double apartamentSize) {
        this.apartamentSize = apartamentSize;
    }


    @Basic
    private double apartamentSize;


    @OneToOne(
            mappedBy = "propertyInsurance",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private PropertyAdress propertyAdress;

    public PropertyInsurance() {

    }

    public double getApartamentSize() {
        return apartamentSize;
    }

    public PropertyAdress getPropertyAdress() {
        return propertyAdress;
    }

    public void setPropertyAdress(PropertyAdress propertyAdress) {
        this.propertyAdress = propertyAdress;
    }

    public void setApartamentSize(double apartamentSize) {
        this.apartamentSize = apartamentSize;
    }

    @Transient
    public double countInsuranceRisk() {
        return apartamentSize*2500;
    }

}
