package com.finalmas.app.model;

import com.finalmas.app.model.complexFields.ContantData;
import com.finalmas.app.model.complexFields.PersonalData;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Person")
public class Person {
    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private PersonalData personalData;
    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private ContantData contantData;

    @OneToOne
    private Client client;

    @OneToOne
    private Agent agent;

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public ContantData getContantData() {
        return contantData;
    }

    public void setContantData(ContantData contantData) {
        this.contantData = contantData;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Person(PersonalData personalData, ContantData contantData) {
        this.personalData = personalData;
        this.contantData = contantData;
        personalData.setPerson(this);
        contantData.setPerson(this);
    }

    public Person() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
