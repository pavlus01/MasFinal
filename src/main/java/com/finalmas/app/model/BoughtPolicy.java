package com.finalmas.app.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "BoughtPolicy")
public class BoughtPolicy {

    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Basic
    private LocalDate creationDate;

    public BoughtPolicy() {

    }

    @ManyToMany
    private List<Client> clientList = new ArrayList<>();

    @ManyToMany
    private List<InsurancePackage> insurancePackageList  = new ArrayList<>();

    public void addClient(Client client){
        clientList.add(client);
        client.getBoughtPolicyList().add(this);
    }

    public void removeClient(Client client){
        clientList.remove(client);
        client.getBoughtPolicyList().remove(this);

        if (this.getClientList().size() <= 1) {
            try {
                throw new Exception("Cannot remove Client - Package must have link to at least one Client");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addInsurancePackage(InsurancePackage insurancePackage){
        insurancePackageList.add(insurancePackage);
        insurancePackage.getBoughtPolicyList().add(this);
    }

    public void removeInsurancePackage(InsurancePackage insurancePackage){
        insurancePackageList.remove(insurancePackage);
        insurancePackage.getBoughtPolicyList().remove(this);

        if (this.getInsurancePackageList().size() <= 1) {
            try {
                throw new Exception("Cannot remove Package - Client must have link to at least one Package");
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

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<InsurancePackage> getInsurancePackageList() {
        return insurancePackageList;
    }

    public void setInsurancePackageList(List<InsurancePackage> insurancePackageList) {
        this.insurancePackageList = insurancePackageList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {CREATED, ACCEPTED, CANCELED,  EXECUTED}

    @Enumerated(EnumType.STRING)
    private Status status;

    public BoughtPolicy(LocalDate creationDate, Status status, Client client, InsurancePackage insurancePackage) {
        this.creationDate = creationDate;
        this.status = status;
        this.addInsurancePackage(insurancePackage);
        this.addClient(client);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
