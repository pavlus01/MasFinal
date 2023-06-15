package com.finalmas.app.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Entity
@Table(name = "Policy")
public class Policy {

    @Basic
    public String name;
    public String description;
    public LocalDate creation_date;
    public LocalDate usefullness_date;
    public double sum_insured;
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    public Policy(String name, String description, LocalDate creationDate, LocalDate usefullnessDate, double sumInsured) {
        this.name = name;
        this.description = description;
        if(creationDate == null || usefullnessDate == null) try{throw new Exception();} catch(Exception e){e.printStackTrace();}
        creation_date = creationDate;
        usefullness_date = usefullnessDate;
        sum_insured = sumInsured;
    }

    public Policy() {

    }

//    public abstract double countInsuranceRisk();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public LocalDate getUsefullness_date() {
        return usefullness_date;
    }

    public double getSum_insured() {
        return sum_insured;
    }

    public boolean deletePolicy(){
        return true;
    }

    @Override
    public String toString(){
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return "Name -> " + name + "\nDescription -> " + description +
                "\nUsefullness date -> " + simpleDateFormat.format(usefullness_date) +
                "\nSum insured -> " + sum_insured;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreation_date(LocalDate creation_date) {
        this.creation_date = creation_date;
    }

    public void setUsefullness_date(LocalDate usefullness_date) {
        this.usefullness_date = usefullness_date;
    }

    public void setSum_insured(double sum_insured) {
        this.sum_insured = sum_insured;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

