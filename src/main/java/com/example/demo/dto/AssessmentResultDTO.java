package com.example.demo.dto;

import java.time.Instant;

public class AssessmentResultDTO {

    private Long id;
    private Long studentProfileId;
    private Long skillId;
    private String assessmentId;
    private Double score;
    private Double maxScore;
    private Instant attemptedAt;

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public Long getStudentProfileId() {
        return studentProfileId;
    }
 
    public void setStudentProfileId(Long studentProfileId) {
        this.studentProfileId = studentProfileId;
    }
 
    public Long getSkillId() {
        return skillId;
    }
 
    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }
 
    public String getAssessmentId() {
        return assessmentId;
    }
 
    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }
 
    public Double getScore() {
        return score;
    }
 
    public void setScore(Double score) {
        this.score = score;
    }
 
    public Double getMaxScore() {
        return maxScore;
    }
 
    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }
 
    public Instant getAttemptedAt() {
        return attemptedAt;
    }
 
    public void setAttemptedAt(Instant attemptedAt) {
        this.attemptedAt = attemptedAt;
    }
}
