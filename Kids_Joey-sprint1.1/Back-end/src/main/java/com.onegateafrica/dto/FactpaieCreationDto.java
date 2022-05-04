package com.onegateafrica.dto;


import com.onegateafrica.entity.Factpaie;

public class FactpaieCreationDto {
    private Factpaie factpaie;
    private String message;
    public FactpaieCreationDto(Factpaie factpaie, String message) {this.factpaie = factpaie;this.message = message;}


    public Factpaie getFactpaie() {
        return factpaie;
    }

    public void setFactpaie(Factpaie factpaie) {
        this.factpaie = factpaie;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}