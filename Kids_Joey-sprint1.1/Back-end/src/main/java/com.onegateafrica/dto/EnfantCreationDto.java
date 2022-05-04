package com.onegateafrica.dto;

import com.onegateafrica.entity.Enfant;


public class EnfantCreationDto {
    private Enfant enfant;
    private String message;

    public EnfantCreationDto(Enfant enfant, String message){
        this.enfant=enfant;
        this.message=message;

    }
    public Enfant getEnfant(){return enfant;}
    public void setEnfant(Enfant enfant){this.enfant = enfant;}
    public String getMessage(){return message;}
    public void setMessage (String message){this.message=message;}
}
