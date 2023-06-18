package com.finalmas.app.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity(name = "InsurancePackage")
public class InsurancePackage {

    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Basic
    private String name;

    @Basic
    private LocalDate creationDate;

    @Transient
    private Map<Policy, Integer> policyNumber = new HashMap<>();

    @Transient
    private List<Policy> policyList = new ArrayList<>();

    @Transient
    private int counter = 0;

    @Transient
    private static Map<String, InsurancePackage> nameMap = new HashMap<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Opinion> opinionList = new ArrayList<>();

    public void addOpinion(Opinion opinion){
        this.getOpinionList().add(opinion);
        opinion.setInsurancePackage(this);
    }

    public void switchOpinion(Opinion opinion, InsurancePackage insurancePackage){
        this.getOpinionList().remove(opinion);
        opinion.setInsurancePackage(insurancePackage);
    }

    @ManyToOne
    private Agent agent;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public List<Opinion> getOpinionList() {
        return opinionList;
    }

    public void setOpinionList(List<Opinion> opinionList) {
        this.opinionList = opinionList;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @ManyToMany(
            cascade = CascadeType.ALL)
    private List<BoughtPolicy> boughtPolicyList = new ArrayList<>();

    public void addBoughtPolicy(BoughtPolicy boughtPolicy){
        boughtPolicyList.add(boughtPolicy);
        boughtPolicy.getInsurancePackageList().add(this);
    }

    public void removeBoughtPolicy(BoughtPolicy boughtPolicy) {
        boughtPolicyList.remove(boughtPolicy);
        boughtPolicy.getInsurancePackageList().remove(this);
    }


    public static Map<String, InsurancePackage> getNameMap() {
        return nameMap;
    }

    public static void setNameMap(Map<String, InsurancePackage> nameMap) {
        InsurancePackage.nameMap = nameMap;
    }

    public List<BoughtPolicy> getBoughtPolicyList() {
        return boughtPolicyList;
    }

    public void setBoughtPolicyList(List<BoughtPolicy> boughtPolicyList) {
        this.boughtPolicyList = boughtPolicyList;
    }

    @ManyToOne
    private PackagedPolicy packagedPolicy;


    public PackagedPolicy getPackagedPolicy() {
        return packagedPolicy;
    }

    public void setPackagedPolicy(PackagedPolicy packagedPolicy) {
        this.packagedPolicy = packagedPolicy;
    }

    public InsurancePackage(String name) {
        this.name = name;
        this.creationDate = LocalDate.now();
    }


    public InsurancePackage(String name, LocalDate creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }
    @Transient
    public void addToPolicyList(Policy policy){
        getPolicyList().add(policy);
        getPolicyNumber().put(policy, counter);
        counter++;
    }

    @Transient
    public void removeFromPolicyList(Policy policy){
        getPolicyList().remove(policy);
        getPolicyNumber().remove(policy);
    }

    public Map<Policy, Integer> getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Map<Policy, Integer> policyNumber) {
        this.policyNumber = policyNumber;
    }

    public List<Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<Policy> policyList) {
        this.policyList = policyList;
    }

    public InsurancePackage() {}
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!nameMap.containsKey(name)) {
            this.name = name;
            nameMap.put(name, this);
        } else {
            try {
                throw new Exception("Given name is already taken!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


}
