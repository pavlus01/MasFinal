package com.finalmas.app.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PackagedPolicy")
public class PackagedPolicy {
    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Basic
    private LocalDate addedToPackage;


    @OneToMany(
            cascade = CascadeType.MERGE,
            orphanRemoval = true)
    private List<Policy> policyList = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.MERGE,
            orphanRemoval = true)
    private List<InsurancePackage> packageList = new ArrayList<>();

    @Transient
    public void addPackage(InsurancePackage insurancePackage){
        getPackageList().add(insurancePackage);
        insurancePackage.setPackagedPolicy(this);
    }

    @Transient
    public void deletePackage(InsurancePackage insurancePackage){
        getPackageList().remove(insurancePackage);
        insurancePackage.setPackagedPolicy(null);
    }

    @Transient
    public void addPolicy(Policy policy){
       getPolicyList().add(policy);
       policy.setPackagedPolicy(this);

       /**
        *  Paying attention to order stereotype and unique Policy identifier
        * */
        for (InsurancePackage in : getPackageList()) {
            in.addToPolicyList(policy);
        }
    }

    @Transient
    public void deletePolicy(Policy policy){
        getPolicyList().remove(policy);
        policy.setPackagedPolicy(null);

        /**
         *  Paying attention to order stereotype and unique Policy identifier
         * */
        for (InsurancePackage in : getPackageList()) {
            in.removeFromPolicyList(policy);
        }
    }

    public LocalDate getAddedToPackage() {
        return addedToPackage;
    }

    public void setAddedToPackage(LocalDate addedToPackage) {
        this.addedToPackage = addedToPackage;
    }


    public PackagedPolicy( LocalDate addedToPackage) {
        this.addedToPackage = addedToPackage;
    }


    public List<Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<Policy> policyList) {
        this.policyList = policyList;
    }

    public List<InsurancePackage> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<InsurancePackage> packageList) {
        this.packageList = packageList;
    }

    public PackagedPolicy() {}
}
