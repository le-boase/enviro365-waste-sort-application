package com.enviro.assessment.grad001.LesegoBoase.dto;

import jakarta.validation.constraints.NotBlank;

public class RecyclingTipDTO {

    @NotBlank(message = "Tip is required")
    private String tip;

    // Getters and Setters
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}