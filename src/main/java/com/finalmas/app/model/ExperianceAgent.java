package com.finalmas.app.model;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.Date;

@Entity(name = "ExperianceAgent")
public class ExperianceAgent extends Agent {

    @Basic
    private LocalDate experianceDate;

    public ExperianceAgent(Agent agent, LocalDate experianceDate, Person person) throws Exception {
        super(agent.getEmploymentData(), agent.getHourSalary(), agent.getYearMark(), agent.getFormerCompanies(),  person);
        if (agent.seniority() < 15) throw new Exception(String.format("Agent is not experianced enough to became Experiance Agent : (%s) years of experiance", (agent.seniority()+"")));
        if(experianceDate == null) try{throw new Exception();} catch(Exception e){e.printStackTrace();}
        this.experianceDate = experianceDate;
    }

    public ExperianceAgent() {

    }
}
