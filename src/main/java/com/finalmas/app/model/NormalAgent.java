package com.finalmas.app.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "NormalAgent")
public class NormalAgent extends Agent {

    public NormalAgent() {
    }

    public NormalAgent(Agent agent, Person person) throws Exception {
        super(agent.getEmploymentData(), agent.getHourSalary(), agent.getYearMark(), agent.getFormerCompanies(), person);
        if (agent.seniority() > 15) throw new Exception(String.format("Agent is too experiance to became Normal Agent : (%s) years of experiance", (agent.seniority()+"")));
    }

}
