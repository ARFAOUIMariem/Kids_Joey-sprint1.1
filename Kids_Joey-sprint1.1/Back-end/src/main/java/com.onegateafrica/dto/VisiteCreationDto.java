package com.onegateafrica.dto;

import com.onegateafrica.entity.Visite;

public class VisiteCreationDto {
    private Visite visite;


    private String message;

    public VisiteCreationDto(Visite visite, String message) {
        this.visite = visite;

        this.message = message;
    }

    public Visite getVisite() {
        return visite;
    }

    public void setVisite(Visite visite) {
        this.visite = visite;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}