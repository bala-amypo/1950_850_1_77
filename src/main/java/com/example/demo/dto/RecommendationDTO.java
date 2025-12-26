package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendationDTO {
    private Long studentProfileId;
    private Long skillId;
    private String skillName;
    private Integer gapScore;
    private String recommendation;
}
