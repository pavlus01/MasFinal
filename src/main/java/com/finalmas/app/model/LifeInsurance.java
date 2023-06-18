package com.finalmas.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity(name = "LifeInsurance")
public class LifeInsurance extends Policy{


    public LifeInsurance(String name, String description, LocalDate creationDate, LocalDate usefullnessDate, double sumInsured) {
        super(name, description, creationDate, usefullnessDate, sumInsured);
    }

    public LifeInsurance() {
    }

    @Transient
    public double countInsuranceRisk() {
        return getSum_insured()*2500;
    }
}
