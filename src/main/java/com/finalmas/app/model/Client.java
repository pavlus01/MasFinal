package com.finalmas.app.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Client")
public class Client {
    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Basic
    private int clientId;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Person person;
    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<BoughtPolicy> boughtPolicyList = new ArrayList<>();

    public Client(int clientId, Person person) {
        this.clientId = clientId;
        this.setPerson(person);
    }

    public Client() {

    }

    public void addBoughtPolicy(BoughtPolicy boughtPolicy){
        boughtPolicyList.add(boughtPolicy);
        boughtPolicy.getClientList().add(this);
    }

    public void removeBoughtPolicy(BoughtPolicy boughtPolicy) {
        boughtPolicyList.remove(boughtPolicy);
        boughtPolicy.getClientList().remove(this);
    }
    public List<BoughtPolicy> getBoughtPolicyList() {
        return boughtPolicyList;
    }

    public void setBoughtPolicyList(List<BoughtPolicy> boughtPolicyList) {
        this.boughtPolicyList = boughtPolicyList;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        person.setClient(this);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
