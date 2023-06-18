package com.finalmas.app.model.complexFields;

import com.finalmas.app.model.Person;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity(name = "PersonalData")
public class PersonalData {
    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Basic
    private String firstName;
    @Basic
    private String secondName;
    @Basic
    private LocalDate birthDate;

    @OneToOne
    private Person person;

    public PersonalData() {}

    public enum Gender {MALE, FEMALE, NOT_GIVEN }
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public PersonalData(String firstName, String secondName, LocalDate birthDate, Gender gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
