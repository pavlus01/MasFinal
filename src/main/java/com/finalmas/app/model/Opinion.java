package com.finalmas.app.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;

@Entity(name = "")
public class Opinion {
    @jakarta.persistence.Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Basic
    private LocalDate creationDate;

    @Basic
    private String problemDescription;

    @Transient
    private Optional<String> recommendationOptional;

    @Basic
    private String recommendation;

    public InsurancePackage getInsurancePackage() {
        return insurancePackage;
    }

    public void setInsurancePackage(InsurancePackage insurancePackage) {
        this.insurancePackage = insurancePackage;
    }

    @ManyToOne
    private InsurancePackage insurancePackage;

    public Opinion(LocalDate creationDate, String problemDescription, Optional<String> recommendationOptional) throws Exception {
        this.creationDate = creationDate;
        this.setProblemDescription(problemDescription);
        this.setRecommendationOptional(recommendationOptional);
    }

    public Opinion() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) throws Exception {
        if (problemDescription.length() > 200){
            throw new Exception(String.format("The description: (%s) is too long", problemDescription));
        }
        this.problemDescription = problemDescription;
    }

    public Optional<String> getRecommendationOptional() {
        return recommendationOptional;
    }

    public void setRecommendationOptional(Optional<String> recommendationOptional) throws Exception {
        if (recommendationOptional.isPresent() && recommendationOptional.get().length() > 300){
            throw new Exception(String.format("The description: (%s) is too long", recommendationOptional.get()));
        }
        if (recommendationOptional.isPresent()) {
            this.recommendation = recommendationOptional.get();
        }
        this.recommendationOptional = recommendationOptional;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    public String toString(){
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return "Creation date -> " + creationDate.toString() +
                "\nDescription -> " + problemDescription + "\nrecommendation -> " +
                (recommendationOptional.orElse("empty"));
    }
}

