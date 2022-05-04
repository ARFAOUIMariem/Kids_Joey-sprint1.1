package com.onegateafrica.entity;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "Enfant")
public class Enfant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private  String prenon;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private  String date_naissance= sdf.format(new Date());
    private long num_inscription;
    private boolean allergie;
    private String typeAllergie;
    private String description;
    private String imageEnfant;
    private Integer idParent;
    }