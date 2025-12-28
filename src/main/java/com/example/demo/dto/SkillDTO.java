package com.example.demo.dto;

public class SkillDTO {

    private Long id;
    private String code;
    private String category;
    private String description;
    private Double minCompetencyScore;
    private Boolean active;

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getCategory() {
        return category;
    }
 
    public void setCategory(String category) {
        this.category = category;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public Double getMinCompetencyScore() {
        return minCompetencyScore;
    }
 
    public void setMinCompetencyScore(Double minCompetencyScore) {
        this.minCompetencyScore = minCompetencyScore;
    }
 
    public Boolean getActive() {
        return active;
    }
 
    public void setActive(Boolean active) {
        this.active = active;
    }
}
