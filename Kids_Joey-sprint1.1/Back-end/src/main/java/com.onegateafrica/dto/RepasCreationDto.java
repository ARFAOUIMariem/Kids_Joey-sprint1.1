package com.onegateafrica.dto;
import com.onegateafrica.entity.repas;
public class RepasCreationDto {
    private repas repas;


    private String message;

    public RepasCreationDto(repas repas,String message ) {
        this.repas = repas;
        this.message=message;
    }

    public repas getRepas() {
        return repas;
    }

    public void setRepas(repas repas) {
        this.repas = repas;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
