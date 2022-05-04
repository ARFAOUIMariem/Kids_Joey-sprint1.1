package com.onegateafrica.dto;


import com.onegateafrica.entity.Planning;

public class PlanningCreationDto {
    private Planning planning;


    private String message;

    public PlanningCreationDto(Planning planning, String message) {
        this.planning = planning;

        this.message = message;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

