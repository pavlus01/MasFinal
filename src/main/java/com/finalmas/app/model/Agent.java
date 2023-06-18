package com.finalmas.app.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Agent")
@Inheritance(strategy = InheritanceType.JOINED)
public class Agent {
    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Basic
    private LocalDate employmentData;

    @Basic
    private double hourSalary;

    public static int years_to_experiance  = 15;
    @Basic
    private int yearMark;

    @ElementCollection
    private List<String> formerCompanies;

    @Transient
    private static List<Agent> agentList;

    @OneToMany(
                    cascade = CascadeType.ALL,
                    orphanRemoval = true)
    private List<InsurancePackage> insurancePackageList = new ArrayList<>();

    public Agent() {

    }

    public void addInsurancePackage(InsurancePackage insurancePackage){
        this.getInsurancePackageList().add(insurancePackage);
        insurancePackage.setAgent(this);
    }

    public void removeInsurancePackage(InsurancePackage insurancePackage){
        this.getInsurancePackageList().remove(insurancePackage);
        insurancePackage.setAgent(this);
    }

    public LocalDate getEmploymentData() {
        return employmentData;
    }

    public void setEmploymentData(LocalDate employmentData) {
        this.employmentData = employmentData;
    }

    public Agent(LocalDate employmentData, double hourSalary, int yearMark, List<String> formerCompanies, Person person) {
        this.employmentData = employmentData;
        this.hourSalary = hourSalary;
        this.yearMark = yearMark;
        this.formerCompanies = formerCompanies;
        Agent.agentList.add(this);
        this.setPerson(person);
        person.setAgent(this);
    }

    public double getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(double hourSalary) {
        this.hourSalary = hourSalary;
    }

    public static int getYears_to_experiance() {
        return years_to_experiance;
    }

    public static void setYears_to_experiance(int years_to_experiance) {
        Agent.years_to_experiance = years_to_experiance;
    }

    public int getYearMark() {
        return yearMark;
    }

    public void setYearMark(int yearMark) {
        this.yearMark = yearMark;
    }

    public List<String> getFormerCompanies() {
        return formerCompanies;
    }

    public void setFormerCompanies(List<String> formerCompanies) {
        this.formerCompanies = formerCompanies;
    }

    public List<InsurancePackage> getInsurancePackageList() {
        return insurancePackageList;
    }

    public void setInsurancePackageList(List<InsurancePackage> insurancePackageList) {
        this.insurancePackageList = insurancePackageList;
    }

    public boolean markAgent(int yearMark){
        this.setYearMark(yearMark);
        return true;
    }

    @Transient
    public int seniority(){
        return LocalDate.now().getYear() - this.employmentData.getYear();
    }

    public static  List<Agent> showAgents(){
        return Agent.agentList;
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
