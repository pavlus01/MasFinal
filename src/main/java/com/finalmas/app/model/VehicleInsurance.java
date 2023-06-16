package com.finalmas.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "VehicleInsurance")
public class VehicleInsurance extends Policy{

    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public double countInsuranceRisk() {
        return 0;
    }
}
