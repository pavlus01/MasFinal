package com.finalmas.app.model;

import com.finalmas.app.repository.PolicyRepository;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Policy")
@Inheritance(strategy = InheritanceType.JOINED)
public class Policy {

    @Basic
    public String name;
    @Basic
    public String description;
    @Basic
    public LocalDate creation_date;
    @Basic
    public LocalDate usefullness_date;
    @Basic
    public double sum_insured;

    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Policy(String name, String description, LocalDate creationDate, LocalDate usefullnessDate, double sumInsured) {
        this.setName(name);
        this.description = description;
        if(creationDate == null || usefullnessDate == null) try{throw new Exception();} catch(Exception e){e.printStackTrace();}
        creation_date = creationDate;
        usefullness_date = usefullnessDate;
        sum_insured = sumInsured;
    }

    public Policy() {}

    @ManyToOne
    private PackagedPolicy packagedPolicy;

    public PackagedPolicy getPackagedPolicy() {
        return packagedPolicy;
    }

    public void setPackagedPolicy(PackagedPolicy packagedPolicy) {
        this.packagedPolicy = packagedPolicy;
    }

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

    @Transient
    public boolean deletePolicy(PolicyRepository repository){
        repository.delete(this);
        return true;
    }

    @Override
    @Transient
    public String toString(){
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return "Name -> " + name + "\nDescription -> " + description +
                "\nUsefullness date -> " + usefullness_date.toString() +
                "\nSum insured -> " + sum_insured;
    }

    public void setName(String name) {
        if (name.length() <= 100)
            this.name = name;
        else {
            try {
                throw new Exception("Given name is too long!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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

}

