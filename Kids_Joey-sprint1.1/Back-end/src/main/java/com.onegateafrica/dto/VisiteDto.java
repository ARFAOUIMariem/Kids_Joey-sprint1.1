package com.onegateafrica.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VisiteDto {
    private long id;
    private String information;
    private LocalDate dateVisite;
    private String nomVisite;
    public long getVisiteDtoId(){
        return getId();
    }

    public VisiteDto(long id, String information, LocalDate dateVisite, String nomVisite) {
        this.id = id;
        this.information = information;
        this.dateVisite = dateVisite;
        this.nomVisite = nomVisite;
    }

    public VisiteDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public LocalDate getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(LocalDate dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getNomVisite() {
        return nomVisite;
    }

    public void setNomVisite(String nomVisite) {
        this.nomVisite = nomVisite;
    }



}
