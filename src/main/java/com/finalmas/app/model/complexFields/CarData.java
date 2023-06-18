package com.finalmas.app.model.complexFields;

import com.finalmas.app.model.VehicleInsurance;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;


@Entity(name = "CarData")
public class CarData {
    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
private Long id;
    @Basic
    private String brand;
    @Basic
    private String model;
    @Basic
    private String number;
    @Basic
    private LocalDate releaseDate;

    @OneToOne
    @JoinColumn(name = "carData_Id")
    private VehicleInsurance vehicleInsurance;

    public CarData(String brand, String model, String number,  LocalDate releaseDate) {
        this.brand = brand;
        this.model = model;
        this.number = number;
        this.releaseDate = releaseDate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public VehicleInsurance getVehicleInsurance() {
        return vehicleInsurance;
    }

    public void setVehicleInsurance(VehicleInsurance vehicleInsurance) {
        this.vehicleInsurance = vehicleInsurance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CarData() {

    }
}
