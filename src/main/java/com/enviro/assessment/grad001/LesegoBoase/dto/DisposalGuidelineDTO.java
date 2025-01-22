package com.enviro.assessment.grad001.LesegoBoase.dto;

import jakarta.validation.constraints.NotBlank;

public class DisposalGuidelineDTO {

    @NotBlank(message = "Guideline is required")
    private String guideline;

    // Getters and Setters
    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }
}