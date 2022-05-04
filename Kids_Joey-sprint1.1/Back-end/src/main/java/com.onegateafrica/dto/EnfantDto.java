package com.onegateafrica.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class EnfantDto {


    private long id;
    private String nom;
    private String prenon;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private String date_naissance= sdf.format(new Date());
    private long num_inscription;
    private boolean allergie;
    private String typeAllergie;
    private String description;
    private String imageEnfant;
    private long idParent;
    public long getEnfantDtoId(){
        return getId();
    }

    public EnfantDto() {
    }

    public EnfantDto(long id, String non, String prenon, long num_inscription, boolean allergie, String type, String description, String data_naissance, String imageEnfant,long idParent) {
        this.id = id;
        this.nom = non;
        this.prenon = prenon;
        this.num_inscription = num_inscription;
        this.allergie = allergie;
        this.typeAllergie = getTypeAllergie();
        this.description = description;
        this.date_naissance = data_naissance;
        this.imageEnfant = imageEnfant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id= id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenon() {
        return prenon;
    }

    public void setPrenon(String prenon) {
        this.prenon = prenon;
    }

    public long getNum_inscription() {
        return num_inscription;
    }

    public void setNum_inscription(long num_inscription) {
        this.num_inscription = num_inscription;
    }

    public String getTypeAllergie() {
        return typeAllergie;
    }

    public void setTypeAllergie(String typeAllergie) {
        this.typeAllergie = typeAllergie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAllergie() {
        return allergie;
    }

    public void setAllergie(boolean allergie) {
        this.allergie = allergie;
    }

    public String getDate_naissance() {
        return date_naissance;}

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;}

    public String getImageEnfant() {
        return imageEnfant;
    }

    public void setImageEnfant(String imageEnfant) {
        this.imageEnfant= imageEnfant;
    }

    public long getIdParent() {
        return idParent;
    }

    public void setIdParent(long idParent) {
        this.idParent = idParent;
    }
}
