package com.onegateafrica.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "visite")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Visite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String information;
    private LocalDate dateVisite;
    private String nomVisite;


}

