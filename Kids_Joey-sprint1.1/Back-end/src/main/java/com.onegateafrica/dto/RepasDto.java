package com.onegateafrica.dto;

import lombok.Data;

@Data
public class RepasDto {


    private long id;
    private String nom;
    private String description;
    private String image;

    public RepasDto() {
    }
    public long getRepasDtoId(){
        return getId();
    }

    public RepasDto(long id,String nom,String description,String image) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.image = image;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
