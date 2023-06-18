package com.finalmas.app.model;

import com.finalmas.app.model.complexFields.CarData;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity(name = "VehicleInsurance")
public class VehicleInsurance extends Policy{
//    public VehicleInsurance(String name, String description, LocalDate creationDate, LocalDate usefullnessDate, double sumInsured) {
//        super(name, description, creationDate, usefullnessDate, sumInsured);
//    }
    public VehicleInsurance(String name, String description, LocalDate creationDate, LocalDate usefullnessDate, double sumInsured, CarData carData) {
        super(name, description, creationDate, usefullnessDate, sumInsured);
        this.carData = carData;
        carData.setVehicleInsurance(this);
    }

    @OneToOne(
            mappedBy = "vehicleInsurance",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private CarData carData;

    public VehicleInsurance() {

    }

    public CarData getCarData() {
        return carData;
    }

    public void setCarData(CarData carData) {
        this.carData = carData;
    }


    @Transient
    public double countInsuranceRisk() {

//return 2500;
return (LocalDate.now().getYear() - carData.getReleaseDate().getYear())*2500;
    }
}
