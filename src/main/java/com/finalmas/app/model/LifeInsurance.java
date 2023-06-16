package com.finalmas.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity(name = "LifeInsurance")
public class LifeInsurance extends Policy{

    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long Id;

    public LifeInsurance(String name, String description, LocalDate creationDate, LocalDate usefullnessDate, double sumInsured) {
        super(name, description, creationDate, usefullnessDate, sumInsured);
    }

    public LifeInsurance() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Transient
    @Override
    public double countInsuranceRisk() {
        //DOIMPLEMENTOWAĆ
        return 0;
    }
}
